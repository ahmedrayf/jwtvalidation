package com.jwt.validation.controller;

import com.jwt.validation.entity.JWT;
import com.jwt.validation.repository.JWTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redis")
@EnableCaching
public class controller {

    @Autowired
    private JWTRepository jwtRepository;

    @GetMapping("/findAll")
    public List<JWT> findAll(){
        return (List<JWT>) jwtRepository.findAll();

    }

    @PostMapping("/save")
    public void save(@RequestBody JWT jwt){
//        JWT jwt = new JWT(UUID.randomUUID().toString(),jwtRequest.getUserName(),jwtRequest.getToken());
        jwtRepository.save(jwt);
    }

    @Cacheable(key = "#id" , value = "JWT")
    @GetMapping("/find/{id}")
    public JWT getToken(@PathVariable String id){
        System.out.println("Get From DB,");
        return jwtRepository.findById(id).get();

    }
    @GetMapping("/findByToken/{token}")
    public JWT getByToken(@PathVariable String token){
         JWT jwt = jwtRepository.findByToken(token);
        return jwt;

    }

    @GetMapping("/findByUserName/{userName}")
    public List<JWT> getByUserName(@PathVariable String userName){
        List<JWT> jwt = jwtRepository.findByUserName(userName);
        return jwt;

    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        jwtRepository.deleteById(id);
    }

    @DeleteMapping("/deleteBy/{token}")
    public void deleteByToken(@PathVariable String token){
        jwtRepository.deleteByToken(token);
    }
}
