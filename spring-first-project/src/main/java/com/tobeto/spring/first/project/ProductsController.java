package com.tobeto.spring.first.project;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductsController {

    List<Product> inMemoryList = new ArrayList<>();

    //tüm product'ları listeler.
    @GetMapping
    public List<Product> getAll(){
        return inMemoryList;
    }

    //product'ları id'ye göre listeler.
    @GetMapping("{id}")
    public Product getById(@PathVariable int id){
        Product product1 = inMemoryList.stream().filter((p)->p.getId() == id).findFirst().orElseThrow();
        return product1;
    }

    //yeni product ekler.
    @PostMapping
    public void add(@RequestBody Product product){
        inMemoryList.add(product);
    }

    //gönderilen product'ın id'sine göre güncelleme yapar.
    @PutMapping
    public void update(@RequestBody Product product){
        Product product2 = inMemoryList.stream().filter((p)-> p.getId() == product.getId()).findFirst().orElseThrow();
        product2.setName(product.getName());
        product2.setPrice(product.getPrice());
        product2.setCategoryId(product.getCategoryId());
        product2.setStockAmount(product.getStockAmount());
    }

    //path yoluyla girilen id'ye göre güncelleme yapar. İstenirse product'ın id'si de değiştirilebilir.
    @PutMapping("{id}")
    public void updateById(@PathVariable int id, @RequestBody Product product){
        Product product3 = inMemoryList.stream().filter((p)-> p.getId() == id).findFirst().orElseThrow();
        product3.setId(product.getId());
        product3.setName(product.getName());
        product3.setPrice(product.getPrice());
        product3.setCategoryId(product.getCategoryId());
        product3.setStockAmount(product.getStockAmount());
    }

    //product'ı id'ye göre siler.
    @DeleteMapping("/byId/{id}")
    public void deleteById(@PathVariable int id){
        Product product4 = inMemoryList.stream().filter((p)-> p.getId() == id).findFirst().orElseThrow();
        inMemoryList.remove(product4);
    }

    //product'ı name'e göre siler.
    @DeleteMapping("/byName/{name}")
    public void deleteByName(@PathVariable String name){
        Product product5 = inMemoryList.stream().filter((p)-> p.getName().equals(name)).findFirst().orElseThrow();
        inMemoryList.remove(product5);
    }


}
