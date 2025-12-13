package com.projecttuto.vehicule_rental.controllers;


import com.projecttuto.vehicule_rental.DTO.SessionDTO;
import com.projecttuto.vehicule_rental.DTO.UserLoginDataDTO;
import com.projecttuto.vehicule_rental.entities.UserLoginSession;
import com.projecttuto.vehicule_rental.services.UserLoginSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserLoginSessionController {

    private final UserLoginSessionService service;


    @PostMapping("/save")
    public ResponseEntity<UserLoginSession> save(@RequestBody UserLoginDataDTO data) {
        UserLoginSession userLoginSession = service.saveSession(data.getUsername(), data.getEmail());
        return ResponseEntity.ok(userLoginSession);
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<SessionDTO>> findAllUserLoginSessionsByLoginDate(@PathVariable LocalDate date){
        List<SessionDTO> sessions = service.findAllUserLoginSessionsByLoginDate(date);
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
