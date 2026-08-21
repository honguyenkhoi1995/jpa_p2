package com.example.jpap2.controller;
import com.example.jpap2.dto.CustomerDTO; import com.example.jpap2.entity.Customer; import com.example.jpap2.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/customers") public class CustomerController {
 private final CustomerRepository repo; public CustomerController(CustomerRepository repo){this.repo=repo;}
 @PostMapping public Customer create(@RequestBody Customer c){return repo.save(c);}
 @GetMapping public List<CustomerDTO> all(){return repo.findAll().stream().map(c->new CustomerDTO(c.getId(),c.getName(),c.getPhone())).toList();}
}
