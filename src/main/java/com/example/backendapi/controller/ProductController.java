package com.example.backendapi.controller;

import com.example.backendapi.dto.ProductDto;
import com.example.backendapi.dto.RequestObject;
import com.example.backendapi.dto.ResponseObject;
import com.example.backendapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;



    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/find")
    public ResponseEntity<ProductDto> findById(@RequestParam int id) {
       return ResponseEntity.status(HttpStatus.FOUND).body(service.findById(id).get());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam int id){
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).body("Product has been deleted");
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseObject> create(@Valid @RequestBody RequestObject requestObject){
       ResponseObject responseObject =  service.create(requestObject);
       return ResponseEntity.status(HttpStatus.CREATED).body(responseObject);
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseObject> update(@Valid @RequestBody RequestObject requestObject){
        ResponseObject responseObject = service.update(requestObject);
        return ResponseEntity.status(HttpStatus.OK).body(responseObject);
    }

}
