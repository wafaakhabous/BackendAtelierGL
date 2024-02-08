package com.MysqlService.MysqlService.controller;

import com.MysqlService.MysqlService.model.Produit;
import com.MysqlService.MysqlService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public Produit createProduit(
            @RequestParam("image") MultipartFile imageFile,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("quantite") int quantite,
            @RequestParam("description") String description,
            @RequestParam("nomCategorie") String nomCategorie
    ) {
        return productService.createProduit(imageFile, name, price, quantite, description, nomCategorie);
    }

    @GetMapping("/get/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return productService.getProduitById(id);
    }

    @GetMapping("/getAll")
    public List<Produit> getAllProducts() {
        return productService.getAllProducts();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Produit> updateProduit(
            @PathVariable Long id,
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("quantite") int quantite,
            @RequestParam("description") String description,
            @RequestParam("nomCategorie") String nomCategorie
    ) {
        return productService.updateProduit(id, imageFile, name, price, quantite, description, nomCategorie);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduit(@PathVariable Long id) {
        return productService.deleteProduit(id);
    }
}
