package com.user_service_provider.controller;

import com.user_service_provider.dto.UserRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("validate")
@Validated
public class ValidateUserController {

    @PostMapping("user")
    public ResponseEntity<String> validateUser(@RequestBody @Valid UserRequestDTO userRequestDTO){
        return ResponseEntity.ok("validated");
    }
}
