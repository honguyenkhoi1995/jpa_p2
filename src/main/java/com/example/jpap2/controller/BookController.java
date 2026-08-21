package com.example.jpap2.controller;
import com.example.jpap2.entity.Book; import com.example.jpap2.repository.BookRepository;
import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/books") public class BookController {
 private final BookRepository repo; public BookController(BookRepository repo){this.repo=repo;}
 @PostMapping public Book create(@RequestBody Book b){return repo.save(b);}
 @GetMapping("/search") public List<Book> search(@RequestParam(required=false) String author,@RequestParam(required=false) Double minPrice,@RequestParam(required=false) Double maxPrice){
  if(author!=null)return repo.findByAuthorIgnoreCase(author);
  if(minPrice!=null&&maxPrice!=null)return repo.findByPriceBetween(minPrice,maxPrice);
  return repo.findAll();
 }
}
