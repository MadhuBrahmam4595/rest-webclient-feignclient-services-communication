package com.order_service_rest_template_consumer.service;

import com.order_service_rest_template_consumer.model.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserConsumerService {

    private final RestTemplate restTemplate;

    @Value("${provider.service.url}")
    private String providerUrl;

    public UserConsumerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserDTO> getAllUsers() {
        ResponseEntity<UserDTO[]> response = restTemplate.getForEntity(providerUrl, UserDTO[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    public UserDTO getUserById(Long id) {
        String url = providerUrl + "/" + id;
        return restTemplate.getForObject(url, UserDTO.class);
    }

    public UserDTO createUser(UserDTO userDTO) {
        ResponseEntity<UserDTO> response = restTemplate.postForEntity(providerUrl, userDTO, UserDTO.class);
        return response.getBody();
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        String url = providerUrl + "/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserDTO> requestEntity = new HttpEntity<>(userDTO, headers);

        ResponseEntity<UserDTO> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, UserDTO.class);
        return response.getBody();
    }

    public void deleteUser(Long id) {
        String url = providerUrl + "/" + id;
        restTemplate.delete(url);
    }
}


