package com.jwt.validation.repository;

import com.jwt.validation.entity.JWT;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JWTRepository extends CrudRepository<JWT,String> {
    JWT findByToken(String token);
    List<JWT> findByUserName(String userName);
    void deleteByToken(String token);

}
