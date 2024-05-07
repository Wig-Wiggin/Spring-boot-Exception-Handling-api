package com.example.backendapi.utility;

import com.example.backendapi.dto.CategoryDto;
import com.example.backendapi.dto.ProductDto;
import com.example.backendapi.dto.RequestObject;
import com.example.backendapi.entity.Category;
import com.example.backendapi.entity.Product;
import com.example.backendapi.exception.DuplicateProductNameException;
import com.example.backendapi.exception.NoSuchCategoryFoundException;

import java.util.Optional;

public class Utility {

    public static Product toProductEntity(ProductDto dto){
       return new Product(dto.id(), dto.name(), dto.price(), dto.itemLeft());
    }

    public static ProductDto toProductDto(Product product){
        return new ProductDto(product.getId(),product.getName(),product.getPrice(),product.getItemLeft());
    }

    public static Category toCategoryEntity(CategoryDto dto){
        return new Category(dto.id(), dto.name());
    }

    public static CategoryDto toCategoryDto(Category category){
        return new CategoryDto(category.getId(),category.getName());
    }


    //this method is compare incoming values of request object with database if they are exist or not and duplicate
    public static void compareWithDatabase(RequestObject requestObject, Optional<Category> checkCategory, Optional<Product> checkProduct) {

        //checkCategory name is not exit, throw
        if (checkCategory.isEmpty()){
            throw new NoSuchCategoryFoundException();
        }

        //checkProduct is already exist, throw
        if (checkProduct.isPresent()){
            throw new DuplicateProductNameException();
        }
    }
}
