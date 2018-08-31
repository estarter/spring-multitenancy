package com.estarter.spring.multitenancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estarter.spring.multitenancy.db.User;
import com.estarter.spring.multitenancy.db.UserRepository;

@RestController
@SpringBootApplication
public class CustomDsApplication {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomDsApplication.class, args);
    }

}
