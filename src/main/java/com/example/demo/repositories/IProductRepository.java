package com.example.demo.repositories;

import com.example.demo.entity.Product;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
