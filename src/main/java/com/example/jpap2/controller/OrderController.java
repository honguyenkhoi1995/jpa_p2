package com.example.jpap2.controller;
import com.example.jpap2.entity.OrderEntity; import com.example.jpap2.repository.OrderRepository;
import org.springframework.format.annotation.DateTimeFormat; import org.springframework.web.bind.annotation.*; import java.time.LocalDateTime; import java.util.*;
@RestController @RequestMapping("/orders") public class OrderController {
 private final OrderRepository repo; public OrderController(OrderRepository repo){this.repo=repo;}
 @PostMapping public OrderEntity create(@RequestBody OrderEntity o){if(o.getCreatedAt()==null)o.setCreatedAt(LocalDateTime.now());return repo.save(o);}
 @GetMapping("/top") public List<OrderEntity> top(){return repo.findTop5ByOrderByTotalAmountDesc();}
 @GetMapping("/search") public List<OrderEntity> range(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime to){return repo.findByDateRange(from,to);}
}
