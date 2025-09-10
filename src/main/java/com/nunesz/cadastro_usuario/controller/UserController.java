package com.nunesz.cadastro_usuario.controller;


import com.nunesz.cadastro_usuario.business.UserService;
import com.nunesz.cadastro_usuario.infrastructure.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> buscarUserPorEmail(@RequestParam String email){
        return ResponseEntity.ok(userService.buscarUserPorEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletUserEmail(@RequestParam String email){
        userService.deletUserEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUserEmail(@RequestParam String email, @RequestBody User user){
        userService.updateUserEmail(email, user);
        return ResponseEntity.ok().build();
    }

}
