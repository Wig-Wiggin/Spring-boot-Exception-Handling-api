package com.example.backendapi.controller;

import com.example.backendapi.dao.CategoryDao;
import com.example.backendapi.dto.CategoryDto;
import com.example.backendapi.entity.Category;
import com.example.backendapi.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping("/all")
    public ResponseEntity<List> findAll(){
       return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find")
    public ResponseEntity<CategoryDto> findById(@RequestParam("id") int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(category));
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("id") int id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Category is delete successfully");
    }


    @PutMapping("/update")
    public ResponseEntity<CategoryDto> update(@Valid @RequestBody Category category){
        return ResponseEntity.status(HttpStatus.OK).body(service.update(category));
    }


}
