package com.projecttuto.vehicule_rental.repositories;

import com.projecttuto.vehicule_rental.entities.UserLoginSession;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserLoginSessionRepository extends ElasticsearchRepository<UserLoginSession, String> {

    UserLoginSession findUserLoginSessionByEmail(String email);

    UserLoginSession findUserLoginSessionByLoginDate(LocalDate loginDate);



}
