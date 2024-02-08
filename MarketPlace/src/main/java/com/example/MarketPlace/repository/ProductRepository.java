package com.example.MarketPlace.repository;

import com.example.MarketPlace.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produit, Long> {
}
