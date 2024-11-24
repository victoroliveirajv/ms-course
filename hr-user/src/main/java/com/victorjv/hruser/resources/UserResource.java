package com.victorjv.hruser.resources;

import com.victorjv.hruser.entities.User;
import com.victorjv.hruser.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRespository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findAll(@PathVariable Long id){
        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){
        return ResponseEntity.ok(repository.findByEmail(email));
    }
}
