package com.tobeto.spring.first.project;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {

    List<Category> inMemoryList = new ArrayList<>();

    //tüm category'leri listeler.
    @GetMapping
    public List<Category> getAll(){
        return inMemoryList;
    }

    //category'leri id'ye göre listeler.
    @GetMapping("{id}")
    public Category getById(@PathVariable int id){
        Category category1 = inMemoryList.stream().filter((c)->c.getId() == id).findFirst().orElseThrow();
        return category1;
    }

    //yeni category ekler.
    @PostMapping
    public void add(@RequestBody Category category){
        inMemoryList.add(category);
    }

    //gönderilen category'nin id'sine göre güncelleme yapar.
    @PutMapping
    public void update(@RequestBody Category category){
        Category category2 = inMemoryList.stream().filter((c)-> c.getId() == category.getId()).findFirst().orElseThrow();
        category2.setName(category.getName());
        category2.setSubCategory(category.getSubCategory());
    }

    //path yoluyla girilen id'ye göre güncelleme yapar. İstenirse category'nin id'si de değiştirilebilir.
    @PutMapping("{id}")
    public void updateById(@PathVariable int id, @RequestBody Category category){
        Category category3 = inMemoryList.stream().filter((c)-> c.getId() == id).findFirst().orElseThrow();
        category3.setId(category.getId());
        category3.setName(category.getName());
        category3.setSubCategory(category.getSubCategory());
    }

    //category'yi id'ye göre siler.
    @DeleteMapping("/byId/{id}")
    public void deleteById(@PathVariable int id){
        Category category4 = inMemoryList.stream().filter((c)->c.getId() == id).findFirst().orElseThrow();
        inMemoryList.remove(category4);
    }

    
}
