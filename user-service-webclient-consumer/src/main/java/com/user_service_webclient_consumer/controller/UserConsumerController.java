package com.user_service_webclient_consumer.controller;

import com.user_service_webclient_consumer.dto.NewUsersDTO;
import com.user_service_webclient_consumer.service.UserConsumenrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consume/users")
@RequiredArgsConstructor
public class UserConsumerController {

    private final UserConsumenrService userConsumenrService;

    @GetMapping("{id}")
    public String getUserById(@PathVariable String id){
        return userConsumenrService.getUserById(id);
    }

    @GetMapping("search")
    public List<NewUsersDTO> searchUser(@RequestParam String name, @RequestParam int age){
        return userConsumenrService.searchUser(name, age);
    }

    @PostMapping
    public NewUsersDTO saveUser(@RequestBody NewUsersDTO newUsersDTO){
        return userConsumenrService.saveUser(newUsersDTO);
    }

    @PutMapping("{id}")
    public NewUsersDTO updateUser(@PathVariable Long id, @RequestBody NewUsersDTO newUsersDTO){
        return userConsumenrService.updateUser(id, newUsersDTO);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Long id){
        userConsumenrService.deleteUserById(id);
    }
}
