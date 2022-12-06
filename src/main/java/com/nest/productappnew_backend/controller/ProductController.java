package com.nest.productappnew_backend.controller;

import com.nest.productappnew_backend.dao.ProductDao;
import com.nest.productappnew_backend.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao dao;

    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String homePage(){
        return "Welcome to my website";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public String addPage(@RequestBody ProductModel p){
        dao.save(p);
        return "product added successfully";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<ProductModel> viewPage(){
        return (List<ProductModel>) dao.findAll();
    }
}
