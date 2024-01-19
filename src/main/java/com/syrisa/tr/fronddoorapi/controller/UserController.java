package com.syrisa.tr.fronddoorapi.controller;

import com.syrisa.tr.fronddoorapi.errorhandling.ErrorMessage;
import com.syrisa.tr.fronddoorapi.model.User;
import com.syrisa.tr.fronddoorapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    private final UserService<User> userService;

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user){
        try {
            System.out.println(user);
            return ResponseEntity.ok(userService.create(user));
        }catch (Exception e){

            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user){
        try {
            return ResponseEntity.ok(userService.update(user));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable int id){
        try {
            return ResponseEntity.ok(userService.getById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll(){
        try {
            return ResponseEntity.ok(userService.getAll());
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email){
        try {
            return ResponseEntity.ok(userService.getByEmail(email));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ErrorMessage> delete(@PathVariable int id){
        try {
            String message = userService.delete(id);
            if (message.equals("User deleted.")){
                return ResponseEntity.ok(new ErrorMessage(new Date(),message));
            }
            return ResponseEntity.badRequest().body(new ErrorMessage(new Date(), message));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}

