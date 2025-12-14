package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.DTO.SessionDTO;
import com.projecttuto.vehicule_rental.DTO.UserLoginDataDTO;
import com.projecttuto.vehicule_rental.entities.UserLoginSession;
import com.projecttuto.vehicule_rental.services.UserLoginSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/sessions")
@CrossOrigin("*")
public class UserLoginSessionController {

    private final UserLoginSessionService service;
    public UserLoginSessionController(UserLoginSessionService service) {
        this.service = service;
    }


    @PostMapping("/save")
    public ResponseEntity<Void> save(@AuthenticationPrincipal Jwt jwt) {
        service.saveSession(jwt);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{date}/{id}")
    public ResponseEntity<List<SessionDTO>> findAllUserLoginSessionsByLoginDate(@PathVariable Instant date, @PathVariable String id){
        List<SessionDTO> sessions = service.findAllUserLoginSessionsByLoginDate(date,id);
        return ResponseEntity.ok().body(sessions);
    }

    @GetMapping("/")
    public ResponseEntity<List<SessionDTO>> findAllUserLoginSessions(){
        List<SessionDTO> sessions = service.findAllUserLoginSessions();
        return ResponseEntity.ok().body(sessions);
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<SessionDTO>> findAllUserLoginSessionsByLoginDate(@PathVariable String email){
        List<SessionDTO> sessions = service.findAllUserLoginSessionsByEmail(email);
        return ResponseEntity.ok().body(sessions);
    }



}
