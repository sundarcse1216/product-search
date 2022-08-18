package com.xyz.product.repository;

import com.xyz.product.entity.Products;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Products, String> {
}
