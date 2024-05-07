package com.example.backendapi;

import com.example.backendapi.dao.CategoryDao;
import com.example.backendapi.entity.Category;
import com.example.backendapi.entity.Product;
import com.example.backendapi.service.CategoryService;
import com.example.backendapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@RequiredArgsConstructor
public class BackendApiApplication implements CommandLineRunner {

    private final CategoryService categoryService;


    private final CategoryDao categoryDao;

    public static void main(String[] args) {
        SpringApplication.run(BackendApiApplication.class, args);
    }

    @Override

    public void run(String... args) throws Exception {
        init();
    }






    @Transactional
    public void  init(){

        Category snack = new Category("Snack");
        Category water = new Category("Water");
        Category juice = new Category("Juice");
        Category bread = new Category("Bread");
        Category computer = new Category("Computer");

        Product product1 = new Product("potato chips",800,300);
        Product product2 = new Product("chicken wings",500,200);
        Product product3 = new Product("instance noodle",1000,500);

        snack.saveProduct(product1);
        snack.saveProduct(product2);
        snack.saveProduct(product3);

        Product product4 = new Product("Fiji Water",600,5000);
        Product product5 = new Product("Evian",500,7000);
        Product product6 = new Product("Nestlé",800,10000);
        Product product7 = new Product("Kingfisher",600,8000);

        water.saveProduct(product4);
        water.saveProduct(product5);
        water.saveProduct(product6);
        water.saveProduct(product7);


        Product product8 = new Product("PepsiCo",800,100000);
        Product product9 = new Product("Coca-Cola",1500,50000000);
        Product product10 = new Product("Ocean Spray",1000,800000);

        juice.saveProduct(product8);
        juice.saveProduct(product9);
        juice.saveProduct(product10);


        Product product11 = new Product("Good Morning",800,100000);
        Product product12 = new Product("Pussy",1500,600000);
        Product product13 = new Product("Goodman Fielder",5000,30000);

        bread.saveProduct(product11);
        bread.saveProduct(product12);
        bread.saveProduct(product13);

        Product product14 = new Product("Apple",10_000_000,6900000);
        Product product15 = new Product("Microsoft",7_000_000,500000);
        Product product16 = new Product("Asus",8_000_000,6000000);

        computer.saveProduct(product14);
        computer.saveProduct(product15);
        computer.saveProduct(product16);

        categoryDao.save(snack);
        categoryDao.save(water);
        categoryDao.save(juice);
        categoryDao.save(bread);
        categoryDao.save(computer);
    }
}
