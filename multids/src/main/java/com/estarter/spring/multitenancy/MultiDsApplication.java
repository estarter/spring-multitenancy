package com.estarter.spring.multitenancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.estarter.spring.multitenancy.db.User;
import com.estarter.spring.multitenancy.db.UserRepository;

@RestController
@SpringBootApplication
public class MultiDsApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MultiDsApplication.class, args);
    }

    @GetMapping("/users")
    public Iterable<User> getUsers(@RequestHeader("X-TenantID") String tenantName) {
        TenantStorage.setTenantName(tenantName);
        return userRepository.findAll();
    }

}
