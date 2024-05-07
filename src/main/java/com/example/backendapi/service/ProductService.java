package com.example.backendapi.service;

import com.example.backendapi.dao.CategoryDao;
import com.example.backendapi.dao.ProductDao;
import com.example.backendapi.dto.ProductDto;
import com.example.backendapi.dto.RequestObject;
import com.example.backendapi.dto.ResponseObject;
import com.example.backendapi.entity.Category;
import com.example.backendapi.entity.Product;
import com.example.backendapi.exception.DuplicateProductNameException;
import com.example.backendapi.exception.NoSuchCategoryFoundException;
import com.example.backendapi.exception.NoSuchProductFoundException;
import com.example.backendapi.utility.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    public List<ProductDto> findAll(){
        return productDao.findAll().stream().map(Utility::toProductDto).toList();
    }

    public Optional<ProductDto> findById(int id){
        if (productDao.existsById(id)){
            return productDao.findById(id).map(Utility::toProductDto);
        }
        throw new NoSuchProductFoundException();
    }

    public void deleteById(int id){
        if (productDao.existsById(id)){
            productDao.deleteById(id);
            return;
        }
        throw new NoSuchProductFoundException();
    }

    @Transactional
    public ResponseObject create(@RequestBody RequestObject requestObject){
       Optional<Category> checkCategory = categoryDao.findCategoryByName(requestObject.categoryName());
       Optional<Product> checkProduct = productDao.findProductByName(requestObject.productName());


        Utility.compareWithDatabase(requestObject, checkCategory, checkProduct);

        //if existed, create new newProduct
       Category existedCategory =  checkCategory.get();

        Product newProduct = new Product(requestObject.productName(), requestObject.price(), requestObject.itemLeft());
        newProduct.setCategory(existedCategory);
        productDao.save(newProduct);
        return new ResponseObject(newProduct.getId(),newProduct.getName(),newProduct.getPrice(),
                newProduct.getItemLeft(), existedCategory.getName(),existedCategory.getId());
    }



    @Transactional
    public ResponseObject update(RequestObject requestObject){
        Optional<Category> checkCategory = categoryDao.findCategoryByName(requestObject.categoryName());
        Optional<Product> checkProduct = productDao.findProductByName(requestObject.productName());

        //checkCategory name is not exit, throw
        if (checkCategory.isEmpty()){
            throw new NoSuchCategoryFoundException();
        }

        //checkProduct name is not exit, throw
        if (checkProduct.isEmpty()){
            throw new NoSuchProductFoundException();
        }

        Product existedProduct = checkProduct.get();
        Category existedCategory = checkCategory.get();
        existedProduct.setName(requestObject.productName());
        existedProduct.setPrice(requestObject.price());
        existedProduct.setItemLeft(requestObject.itemLeft());
        return new ResponseObject(existedProduct.getId(),existedProduct.getName(),existedProduct.getPrice(),
                existedProduct.getItemLeft(),existedCategory.getName(),existedCategory.getId());
    }

}
