package com.xyz.product.service;

import com.xyz.product.entity.Products;
import com.xyz.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Value("${elastic.product.index}")
    private String PRODUCT_INDEX;

    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    public ProductService(ElasticsearchOperations elasticsearchOperations) {
        super();
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public Iterable<Products> getProducts() {
        Iterable<Products> products = productRepository.findAll();
        return products;
    }


    public SearchHits<Products> searchProduct(String keyword) {
        String query = "{\"query\": {\"query_string\": {\"query\": " + keyword + ",\"analyzer\":\"search_ngram_analyzer\"}}}";

        Query searchQuery = new StringQuery(query);
        SearchHits<Products> products = elasticsearchOperations.search(
                searchQuery,
                Products.class,
                IndexCoordinates.of(PRODUCT_INDEX));

        return products;
    }
}
