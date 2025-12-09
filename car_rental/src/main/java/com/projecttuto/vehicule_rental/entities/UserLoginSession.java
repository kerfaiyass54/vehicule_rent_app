package com.projecttuto.vehicule_rental.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Document(indexName = "user_login_sessions")
public class UserLoginSession {

    @Id
    private String id;

    private String username;
    private String email;

    private LocalDate loginDate;
    private LocalTime loginTime;
}