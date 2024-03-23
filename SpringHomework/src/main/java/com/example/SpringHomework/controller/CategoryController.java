package com.example.SpringHomework.controller;

import com.example.SpringHomework.entities.Category;
import com.example.SpringHomework.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @GetMapping
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
    @PostMapping
    public String add(@RequestBody Category category){
        categoryRepository.save(category);
        return "Başarıyla Eklendi.";
    }
    @PutMapping
    public String update(@RequestBody Category category){
        categoryRepository.save(category);
        return "Başarıyla Güncellendi.";
    }
    @DeleteMapping
    public String delete(@RequestParam int id){
       Category category = categoryRepository
               .findById(id)
               .orElseThrow(() -> new RuntimeException("Bu Kategori Bulunamadı."));
       categoryRepository.delete(category);
       return "Başarıyla Silindi";
    }
}
