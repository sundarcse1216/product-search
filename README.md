# Product-search
Product Search

# Pre-Requirement
1. Install elasticsearch-8.1.x
2. Create index using postman <a href="https://github.com/sundarcse1216/product-search/blob/featute/products/elasticsearch.postman_collection.json">collection</a>
3. Start this service
4. Call below APIs

# Index Design
https://github.com/sundarcse1216/product-search/blob/featute/products/index_design

# API Doc

## 1. Gel all document in product index
    Endpoint: /products
    Method: GET

    Response:
    Http code: 200
    Body:
        {...}

## 2. Search Product 
    Endpoint: /products/search/{keyword}
    Method: GET

    Response:
    Http Code: 200
    Body:
        {...}
