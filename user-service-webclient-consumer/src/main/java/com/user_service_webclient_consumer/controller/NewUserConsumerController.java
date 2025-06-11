package com.user_service_webclient_consumer.controller;

import com.user_service_webclient_consumer.dto.NewUsersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/new/api")
@RequiredArgsConstructor
public class NewUserConsumerController {

    @Value("${apiUrl}")
    private String apiUrl;

    private final WebClient webClient;

    @GetMapping("{id}")
    public NewUsersDTO getById(@PathVariable Long id){
        NewUsersDTO user = webClient
                .get()
                .uri(apiUrl + "/new/users/{id}", id)
                .retrieve()
                .bodyToMono(NewUsersDTO.class)
                .block();
        return user;
    }
}
