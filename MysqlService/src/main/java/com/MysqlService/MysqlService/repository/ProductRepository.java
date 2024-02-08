package com.MysqlService.MysqlService.repository;

import com.MysqlService.MysqlService.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Produit, Long> {
}
