package com.user_service_provider.controller;

import com.user_service_provider.dto.UserRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated  // VERY IMPORTANT for validating request params, headers, path variables
public class ValidationUserController {

    // Request Body Validation
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok("User is valid and saved successfully");
    }

    // Request Params Validation
    @GetMapping("/search")
    public ResponseEntity<String> searchUser(
            @RequestParam @NotBlank(message = "Name is required") String name,
            @RequestParam @Min(18) @Max(60) int age) {
        return ResponseEntity.ok("Valid request params");
    }

    // Path Variable Validation
    @GetMapping("/{id}")
    public ResponseEntity<String> getUserById(
            @PathVariable @Min(1) Long id) {
        return ResponseEntity.ok("Valid path variable");
    }

    // Request Header Validation
    @GetMapping("/validate-header")
    public ResponseEntity<String> validateHeader(
            @RequestHeader("X-Request-Id") @NotBlank String requestId) {
        return ResponseEntity.ok("Valid header");
    }
}

