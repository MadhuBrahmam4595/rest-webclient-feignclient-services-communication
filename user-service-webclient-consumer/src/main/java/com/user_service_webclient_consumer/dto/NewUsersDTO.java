package com.user_service_webclient_consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUsersDTO {

    private Long id;
    private String name;
    private int age;
    private String email;
}
