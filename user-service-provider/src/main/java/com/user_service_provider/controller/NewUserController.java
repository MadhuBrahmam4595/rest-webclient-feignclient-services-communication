package com.user_service_provider.controller;

import com.user_service_provider.entity.NewUsers;
import com.user_service_provider.service.NewUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/new/users")
@RequiredArgsConstructor
public class NewUserController {

    private final NewUserService userService;

    @PostMapping
    public ResponseEntity<NewUsers> createUser(@RequestBody NewUsers user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewUsers> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<NewUsers>> searchUser(@RequestParam String name, @RequestParam int age) {
        return ResponseEntity.ok(userService.searchUser(name, age));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewUsers> updateUser(@PathVariable Long id, @RequestBody NewUsers userRequest) {
        return ResponseEntity.ok(userService.updateUser(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}

