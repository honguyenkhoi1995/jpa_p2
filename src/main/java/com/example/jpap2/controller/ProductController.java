package com.example.jpap2.controller;
import com.example.jpap2.entity.Product; import com.example.jpap2.repository.ProductRepository;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/products") public class ProductController {
 private final ProductRepository repo; public ProductController(ProductRepository repo){this.repo=repo;}
 @PostMapping public Product create(@RequestBody Product p){return repo.save(p);}
 @GetMapping public List<Product> all(){return repo.findAll();}
 @GetMapping("/{id}") public Product one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));}
 @PutMapping("/{id}") public Product update(@PathVariable Long id,@RequestBody Product p){Product x=one(id);x.setName(p.getName());x.setPrice(p.getPrice());x.setDescription(p.getDescription());return repo.save(x);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){one(id);repo.deleteById(id);return ResponseEntity.noContent().build();}
}
