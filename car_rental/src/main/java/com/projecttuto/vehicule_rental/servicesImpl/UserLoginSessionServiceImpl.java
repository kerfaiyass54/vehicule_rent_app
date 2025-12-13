package com.projecttuto.vehicule_rental.servicesImpl;

import com.projecttuto.vehicule_rental.DTO.SessionDTO;
import com.projecttuto.vehicule_rental.entities.UserLoginSession;
import com.projecttuto.vehicule_rental.repositories.UserLoginSessionRepository;
import com.projecttuto.vehicule_rental.services.UserLoginSessionService;
import org.springframework.stereotype.Service;

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
        sessionDTO.setLoginTime(userLoginSession.getLoginTime());
        sessionDTO.setLoginDate(userLoginSession.getLoginDate());
        sessionDTO.setLogoutTime(userLoginSession.getLogoutTime());
        sessionDTO.setLogoutDate(userLoginSession.getLogoutDate());
        sessionDTO.setUsername(userLoginSession.getUsername());
        return sessionDTO;
    }

    @Override
    public UserLoginSession saveSession(String username, String email){
        UserLoginSession session = new UserLoginSession();
        session.setUsername(username);
        session.setEmail(email);
        session.setLoginDate(LocalDate.now());
        session.setLoginTime(LocalTime.now());

        return userLoginSessionRepository.save(session);
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
    public List<SessionDTO> findAllUserLoginSessionsByLoginDate(LocalDate loginDate){
        return userLoginSessionRepository.findUserLoginSessionByLoginDate(loginDate).stream().map(this::mapToDTO).toList();
    }


}
