package com.tobeto.spring.first.project;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api2/products")
public class ProductsController {

    @GetMapping
    public String get(){
        return "Ürün listelendi";
    }

    @PostMapping
    public String post(){
        return "Ürün eklendi";
    }

    @PutMapping
    public String put(){
        return "Ürün güncellendi";
    }

    @DeleteMapping
    public String delete(){
        return "Ürün silindi";
    }

}
