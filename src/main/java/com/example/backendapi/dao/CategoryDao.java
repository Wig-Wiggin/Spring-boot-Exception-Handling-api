package com.example.backendapi.dao;

import com.example.backendapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryDao extends JpaRepository<Category,Integer> {

    //TODO : write JPQL or native query for searching bez category name need to be upper case
    Optional<Category> findCategoryByName(String name);

}
