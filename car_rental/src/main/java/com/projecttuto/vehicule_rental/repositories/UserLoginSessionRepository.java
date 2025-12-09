package com.projecttuto.vehicule_rental.repositories;

import com.projecttuto.vehicule_rental.entities.UserLoginSession;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserLoginSessionRepository extends ElasticsearchRepository<UserLoginSession, String> {

    List<UserLoginSession> findUserLoginSessionByEmail(String email);

    List<UserLoginSession> findUserLoginSessionByLoginDate(LocalDate loginDate);



}
