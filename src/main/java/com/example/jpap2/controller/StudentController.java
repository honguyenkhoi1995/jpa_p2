package com.example.jpap2.controller;
import com.example.jpap2.entity.*; import com.example.jpap2.repository.*;
import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/students")
public class StudentController {
    private final StudentRepository students; private final CourseRepository courses;
    public StudentController(StudentRepository students, CourseRepository courses){this.students=students;this.courses=courses;}
    @PostMapping public Student create(@RequestBody Student s){return students.save(s);}
    @GetMapping public List<Student> all(){return students.findAll();}
    @PostMapping("/{id}/courses/{courseId}") public Student enroll(@PathVariable Long id,@PathVariable Long courseId){
        Student s=students.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found"));
        Course c=courses.findById(courseId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Course not found"));
        if(!s.getCourses().contains(c)) s.getCourses().add(c); return students.save(s);
    }
    @GetMapping("/{id}/courses") public List<Course> studentCourses(@PathVariable Long id){return students.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Student not found")).getCourses();}
}
