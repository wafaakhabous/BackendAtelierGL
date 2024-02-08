package com.example.MarketPlace.client;

import com.example.MarketPlace.model.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "data-product", url = "http://localhost:8090/api/product")
public interface DataProduct {

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    void deleteById(@PathVariable Long id);

    @PostMapping("/product/add")
    Produit save(@RequestBody Produit produit);

    @GetMapping("/product/{id}")
    Optional<Produit> findById(@PathVariable("id") long id);

    @GetMapping("/product/all")
    List<Produit> findAll();

    @PostMapping("/product/search/{info}")
    List<Produit> searchProducts(@PathVariable("info") String info);

    @PutMapping("/product/update/{id}")
    Produit updateProduct(@PathVariable("id") long id, @RequestBody Produit updatedProduct);
}
