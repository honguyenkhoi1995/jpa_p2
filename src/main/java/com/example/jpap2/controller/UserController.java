package com.example.jpap2.controller;
import com.example.jpap2.entity.User; import com.example.jpap2.repository.UserRepository;
import jakarta.validation.Valid; import jakarta.validation.constraints.*; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/users") public class UserController {
 private final UserRepository repo; public UserController(UserRepository repo){this.repo=repo;}
 @PostMapping public User create(@Valid @RequestBody UserRequest r){User u=new User();u.setUsername(r.username());u.setEmail(r.email());u.setPassword(r.password());return repo.save(u);}
 @GetMapping public List<User> all(){return repo.findAll();}
 public record UserRequest(@NotBlank String username,@NotBlank @Email String email,@NotBlank @Size(min=6) String password){}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException e){Map<String,Object> body=new LinkedHashMap<>();body.put("status",400);body.put("errors",e.getBindingResult().getFieldErrors().stream().collect(java.util.stream.Collectors.toMap(x->x.getField(),x->x.getDefaultMessage(),(a,b)->a,LinkedHashMap::new)));return ResponseEntity.badRequest().body(body);}
}
