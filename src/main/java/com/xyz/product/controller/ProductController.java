package com.xyz.product.controller;

import com.xyz.product.entity.Products;
import com.xyz.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Products>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping(value = "/search/{keyword}")
    public ResponseEntity<SearchHits<Products>> searchProducts(@PathParam("keyword") String keyword) {
        return ResponseEntity.ok(productService.searchProduct(keyword));
    }
}
