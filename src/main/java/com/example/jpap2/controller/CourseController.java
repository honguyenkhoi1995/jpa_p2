package com.example.jpap2.controller;
import com.example.jpap2.entity.Course; import com.example.jpap2.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/courses") public class CourseController {
 private final CourseRepository repo; public CourseController(CourseRepository repo){this.repo=repo;}
 @PostMapping public Course create(@RequestBody Course c){return repo.save(c);}
}
