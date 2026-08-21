package com.example.jpap2.controller;
import com.example.jpap2.entity.*; import com.example.jpap2.repository.*;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/categories") public class CategoryController {
 private final CategoryRepository categories; private final ProductRepository products;
 public CategoryController(CategoryRepository categories,ProductRepository products){this.categories=categories;this.products=products;}
 @PostMapping public Category create(@RequestBody Category c){return categories.save(c);}
 @PostMapping("/{id}/products") public Product add(@PathVariable Long id,@RequestBody Product p){Category c=categories.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));p.setCategory(c);return products.save(p);}
 @GetMapping("/{id}/products") public List<Product> list(@PathVariable Long id){return categories.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found")).getProducts();}
}
