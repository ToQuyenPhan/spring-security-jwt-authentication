package com.example.demo.controllers;

import com.example.demo.entity.Product;
import com.example.demo.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductRepository repo;

    @GetMapping
    public List<Product> list(){
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody @Valid Product product){
        Product savedProduct = repo.save(product);
        URI productURI = URI.create("/products/" + savedProduct.getId());
        return ResponseEntity.created(productURI).body(savedProduct);
    }
}
