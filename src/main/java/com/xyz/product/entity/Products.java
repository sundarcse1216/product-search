package com.xyz.product.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Products {

    @Id
    private Long id;
    @Field(type = FieldType.Text, name = "name")
    private String name;
    @Field(type = FieldType.Text, name = "brand")
    private String brand;
    @Field(type = FieldType.Double, name = "price")
    private Double price;
    @Field(type = FieldType.Nested, includeInParent = true, name = "category")
    private List<Categories> category;
    @Field(type = FieldType.Nested, includeInParent = true, name = "tags")
    private List<Tags> tags;
}
