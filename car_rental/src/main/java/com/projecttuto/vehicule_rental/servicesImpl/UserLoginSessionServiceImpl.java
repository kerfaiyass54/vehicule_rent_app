package com.projecttuto.vehicule_rental.servicesImpl;

import com.projecttuto.vehicule_rental.DTO.SessionDTO;
import com.projecttuto.vehicule_rental.DTO.UserLoginDataDTO;
import com.projecttuto.vehicule_rental.entities.UserLoginSession;
import com.projecttuto.vehicule_rental.repositories.UserLoginSessionRepository;
import com.projecttuto.vehicule_rental.services.UserLoginSessionService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;



@Service
public class UserLoginSessionServiceImpl implements UserLoginSessionService {

    private final UserLoginSessionRepository userLoginSessionRepository;
    public UserLoginSessionServiceImpl(UserLoginSessionRepository repository) {
        this.userLoginSessionRepository = repository;
    }

    public SessionDTO mapToDTO(UserLoginSession userLoginSession) {
        SessionDTO sessionDTO = new SessionDTO();
        sessionDTO.setEmail(userLoginSession.getEmail());
        sessionDTO.setUsername(userLoginSession.getUsername());
        sessionDTO.setId(userLoginSession.getId());
        sessionDTO.setUserId(userLoginSession.getUserId());
        sessionDTO.setSessionStart(userLoginSession.getSessionStart());
        return sessionDTO;
    }

    @Override
    public void saveSession(Jwt jwt){
        Long authTimeSeconds = jwt.getClaim("auth_time");
        Instant authTime = Instant.ofEpochSecond(authTimeSeconds);
        String userId = jwt.getSubject();
        if (userLoginSessionRepository.existsByUserIdAndSessionStart(userId, authTime)) {
            return;
        }
        UserLoginSession session = new UserLoginSession();
        session.setUserId(userId);
        session.setUsername(jwt.getClaim("preferred_username"));
        session.setEmail(jwt.getClaim("email"));
        session.setSessionStart(authTime);
        userLoginSessionRepository.save(session);
    }

    @Override
    public List<SessionDTO> findAllUserLoginSessions(){
        return ((List<UserLoginSession>) userLoginSessionRepository.findAll()).stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<SessionDTO> findAllUserLoginSessionsByEmail(String email){
        return userLoginSessionRepository.findUserLoginSessionByEmail(email).stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<SessionDTO> findAllUserLoginSessionsByLoginDate(Instant date, String id){
        return userLoginSessionRepository.findUserLoginSessionBySessionStartAndUserId(date,id).stream().map(this::mapToDTO).toList();
    }


}
