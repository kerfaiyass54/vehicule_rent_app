package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.DTO.UserLoginDataDTO;
import com.projecttuto.vehicule_rental.entities.UserLoginSession;
import com.projecttuto.vehicule_rental.services.UserLoginSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class UserLoginSessionController {

    private final UserLoginSessionService service;


    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody UserLoginDataDTO data) {
        service.saveSession(data.getUsername(), data.getEmail());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<UserLoginSession>> findAllUserLoginSessionsByLoginDate(@PathVariable LocalDate date){
        List<UserLoginSession> sessions = service.findAllUserLoginSessionsByLoginDate(date);
        return ResponseEntity.ok().body(sessions);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserLoginSession>> findAllUserLoginSessions(){
        List<UserLoginSession> sessions = service.findAllUserLoginSessions();
        return ResponseEntity.ok().body(sessions);
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<UserLoginSession>> findAllUserLoginSessionsByLoginDate(@PathVariable String email){
        List<UserLoginSession> sessions = service.findAllUserLoginSessionsByEmail(email);
        return ResponseEntity.ok().body(sessions);
    }



}
