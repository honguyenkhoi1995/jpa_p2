package com.example.jpap2.controller;
import com.example.jpap2.entity.Employee; import com.example.jpap2.repository.EmployeeRepository;
import org.springframework.data.domain.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/employees") public class EmployeeController {
 private final EmployeeRepository repo; public EmployeeController(EmployeeRepository repo){this.repo=repo;}
 @PostMapping public Employee create(@RequestBody Employee e){return repo.save(e);}
 @GetMapping public Page<Employee> page(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="5") int size,@RequestParam(defaultValue="salary,desc") String sort){String[] s=sort.split(",");Sort.Direction d=s.length>1&&s[1].equalsIgnoreCase("desc")?Sort.Direction.DESC:Sort.Direction.ASC;return repo.findAll(PageRequest.of(page,size,Sort.by(d,s[0])));}
}
