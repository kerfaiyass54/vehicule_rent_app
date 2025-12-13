package com.projecttuto.vehicule_rental.services;

import com.projecttuto.vehicule_rental.DTO.SessionDTO;
import com.projecttuto.vehicule_rental.entities.UserLoginSession;

import java.time.LocalDate;
import java.util.List;

public interface UserLoginSessionService {

    public UserLoginSession saveSession(String username, String email);

    public List<SessionDTO> findAllUserLoginSessions();

    public List<SessionDTO> findAllUserLoginSessionsByEmail(String email);

    public List<SessionDTO> findAllUserLoginSessionsByLoginDate(LocalDate loginDate);
}
