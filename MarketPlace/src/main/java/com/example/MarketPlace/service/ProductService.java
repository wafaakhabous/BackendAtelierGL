package com.example.MarketPlace.service;

import com.example.MarketPlace.client.DataProduct;
import com.example.MarketPlace.exception.ResourceNotFoundException;
import com.example.MarketPlace.model.Produit;
import com.example.MarketPlace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final DataProduct dataProduct;

    @Autowired
    public ProductService(ProductRepository productRepository, DataProduct dataProduct) {
        this.productRepository = productRepository;
        this.dataProduct = dataProduct;
    }

    public List<Produit> getAllProducts() {
        return productRepository.findAll();
    }

    public Produit createProduit(
            @RequestParam("image") MultipartFile imageFile,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("quantite") int quantite,
            @RequestParam("description") String description,
            @RequestParam("nomCategorie") String nomCategorie
    ) {
        String imagePath = saveImage(imageFile);

        Produit produit = new Produit();
        produit.setName(name);
        produit.setPrice(price);
        produit.setQuantite(quantite);
        produit.setDescription(description);
        produit.setnom_categorie(nomCategorie);
        produit.setImage(imagePath);
        produit.setDate_ajout(LocalDate.now());

        return productRepository.save(produit);
    }

    public Produit getProduitById(@RequestParam("id") Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit avec cet id n'existe pas " + id));
    }

    public ResponseEntity<Produit> updateProduit(
            @RequestParam("id") Long id,
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("quantite") int quantite,
            @RequestParam("description") String description,
            @RequestParam("nomCategorie") String nomCategorie
    ) {
        // Use Feign client to update user details
        dataProduct.updateProduct(id, new Produit(id, name, price, description, null, quantite, nomCategorie, LocalDate.now()));

        Produit produit = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit avec cet id n'existe pas " + id));

        produit.setName(name);
        produit.setPrice(price);
        produit.setQuantite(quantite);
        produit.setDescription(description);
        produit.setnom_categorie(nomCategorie);

        if (imageFile != null) {
            produit.setImage(saveImage(imageFile));
        }

        Produit updatedProduit = productRepository.save(produit);

        return ResponseEntity.ok(updatedProduit);
    }

    public ResponseEntity<Map<String, Boolean>> deleteProduit(@RequestParam("id") Long id) {
        // Use Feign client to delete user
        dataProduct.deleteById(id);

        Produit produit = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit avec cet id n'existe pas " + id));

        productRepository.delete(produit);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    private String saveImage(MultipartFile imageFile) {
        String uploadDir = "C:\\Users\\pc\\Desktop\\FrontTrip\\public\\images\\";
        String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();

        try {
            Path filePath = Paths.get(uploadDir + fileName);
            Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
}
