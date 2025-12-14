package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.DTO.SessionDTO;
import com.projecttuto.vehicule_rental.DTO.UserLoginDataDTO;
import com.projecttuto.vehicule_rental.entities.UserLoginSession;
import org.springframework.security.oauth2.jwt.Jwt;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface UserLoginSessionService {

    public void saveSession(Jwt jwt);

    public List<SessionDTO> findAllUserLoginSessions();

    public List<SessionDTO> findAllUserLoginSessionsByEmail(String email);

    public List<SessionDTO> findAllUserLoginSessionsByLoginDate(Instant date, String id);
}
