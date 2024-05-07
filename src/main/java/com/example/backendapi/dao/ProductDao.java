package com.example.backendapi.dao;

import com.example.backendapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {

    Optional<Product> findProductByName(String name);
}
