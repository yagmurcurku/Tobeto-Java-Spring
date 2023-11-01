package com.tobeto.spring.first.project;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api3/orders")
public class OrdersController {

    @GetMapping
    public String get1(){
        return "1. get metodu ile sipariş getirildi.";
    }

    @GetMapping("/get2")
    public String get2(){
        return "2. get metodu ile sipariş getirildi.";
    }

    @PostMapping
    public String post(){
        return "post metodu ile sipariş eklendi.";
    }

    @PutMapping()
    public String put(){
        return "put metodu sipariş güncellendi";
    }

    @DeleteMapping
    public String delete(){
        return "delete metodu ile tüm siparişler silindi.";
    }

    @DeleteMapping("/byOrderId")
    public String delete1(){
        return "delete metodu ile id'ye göre silme işlemi gerçekleştirildi.";
    }

    @DeleteMapping("/byOrderName")
    public String delete2(){
        return "delete metodu ile sipariş adına göre silme işlemi gerçekleştirildi.";
    }

}
