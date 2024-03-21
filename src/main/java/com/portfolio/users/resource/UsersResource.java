package com.portfolio.users.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portfolio.users.entities.User;
import com.portfolio.users.repositories.UserRepository;
import com.portfolio.users.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;

    // Rota para buscar todos os usuários
    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    // Rota para buscar um usuário pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }

    // Rota para inserir um novo usuário
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody User user) {
        User insertedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(insertedUser);
    }

    // Rota para deletar um usuário pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody User userDetails) { 
        User updatedUser = userService.update(id, userDetails);
        if (updatedUser != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
