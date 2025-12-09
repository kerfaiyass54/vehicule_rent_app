package com.projecttuto.vehicule_rental.servicesImpl;

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
    public List<UserLoginSession> findAllUserLoginSessions(){
        return (List<UserLoginSession>) userLoginSessionRepository.findAll();
    }

    @Override
    public List<UserLoginSession> findAllUserLoginSessionsByEmail(String email){
        return userLoginSessionRepository.findUserLoginSessionByEmail(email);
    }

    @Override
    public List<UserLoginSession> findAllUserLoginSessionsByLoginDate(LocalDate loginDate){
        return userLoginSessionRepository.findUserLoginSessionByLoginDate(loginDate);
    }


}
