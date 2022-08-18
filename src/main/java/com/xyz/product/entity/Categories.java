package com.xyz.product.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class Categories {
    private String name;
    private List<SubCategories> subCategory;
}
