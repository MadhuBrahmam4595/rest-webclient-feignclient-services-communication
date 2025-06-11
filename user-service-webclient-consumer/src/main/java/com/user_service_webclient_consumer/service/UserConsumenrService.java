package com.user_service_webclient_consumer.service;

import com.user_service_webclient_consumer.dto.NewUsersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserConsumenrService {

    private final WebClient webClient;

    @Value("${apiUrl}")
    private String apiUrl;

    // GET with path param and headers
    public String getUserById(String userId){
        return webClient
                .get()
                .uri(apiUrl+"/{id}", userId)
                .header("Authorization", "Bearer dummy-token")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    // GET with request params and headers
    public List<NewUsersDTO> searchUser(String name, int age){
        return webClient
                .get()
                .uri(
                        uriBuilder ->
                                uriBuilder.path("/new/users/search")
                                        .queryParam("name", name)
                                        .queryParam("age", age)
                                        .build()
                )
                .retrieve()
                .bodyToFlux(NewUsersDTO.class)
                .collectList()
                .block();
    }

    public NewUsersDTO saveUser(NewUsersDTO newUsersDTO){
        return webClient
                .post()
                .uri(apiUrl+"/new/users")
                .bodyValue(newUsersDTO)
                .retrieve()
                .bodyToMono(NewUsersDTO.class)
                .block();
    }

    public NewUsersDTO updateUser(Long id, NewUsersDTO newUsersDTO){
        return webClient
                .put()
                .uri(apiUrl+"/new/users/{id}", id)
                .bodyValue(newUsersDTO)
                .retrieve()
                .bodyToMono(NewUsersDTO.class)
                .block();
    }

    public void deleteUserById(Long id){
          webClient
                .delete()
                .uri(apiUrl+"/new/users/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}
