package com.example.backendapi.service;

import com.example.backendapi.dao.CategoryDao;
import com.example.backendapi.dto.CategoryDto;
import com.example.backendapi.entity.Category;
import com.example.backendapi.exception.DuplicateCategoryNameException;
import com.example.backendapi.exception.NoSuchCategoryFoundException;
import com.example.backendapi.utility.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryDao dao;

    public List<CategoryDto> findAll(){
       return dao.findAll().stream().map(Utility::toCategoryDto).toList();
    }

    public CategoryDto create(Category category){
        Optional<Category> checkCategory = dao.findCategoryByName(category.getName());
        if (checkCategory.isPresent()){
            throw new DuplicateCategoryNameException();
        }
        return Utility.toCategoryDto(dao.save(category));
    }

    public CategoryDto findById(int id){
        Optional<Category> checkCategory = dao.findById(id);
        if (checkCategory.isEmpty()){
            throw new NoSuchCategoryFoundException();
        }
        return Utility.toCategoryDto(checkCategory.get());
    }

    public void delete(int id){
        Optional<Category> checkCategory = dao.findById(id);
        if (checkCategory.isEmpty()){
            throw new NoSuchCategoryFoundException();
        }
        dao.deleteById(id);
    }

    public CategoryDto update(Category category){

        List<Category> categoryList = dao.findAll();
        Optional<Category> checkCategory = dao.findById(category.getId());

        if (checkCategory.isEmpty()){
            throw new NoSuchCategoryFoundException();
        }

        boolean isExisted = categoryList.stream().anyMatch(c->c.getName().equals(category.getName()));
        if (isExisted){
            throw new DuplicateCategoryNameException();
        }

        Category existedCategory = checkCategory.get();
        existedCategory.setName(category.getName());
        return Utility.toCategoryDto(existedCategory);
    }

}
