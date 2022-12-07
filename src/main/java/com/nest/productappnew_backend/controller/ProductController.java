package com.nest.productappnew_backend.controller;

import com.nest.productappnew_backend.dao.ProductDao;
import com.nest.productappnew_backend.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public HashMap<String, String> addPage(@RequestBody ProductModel p){
        dao.save(p);
        HashMap<String,String > map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<ProductModel> viewPage(){
        return (List<ProductModel>) dao.findAll();
    }
}
