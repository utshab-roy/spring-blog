package com.utshab.blog;

import com.utshab.blog.models.AppUser;
import com.utshab.blog.models.Role;
import com.utshab.blog.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(AppUserService userService) {
        // everything in here will run after the application initialize
        return args -> {
            // making some roles
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

//            // making some user
            userService.saveUser(new AppUser(null, "Jhon", "jhon", "password", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Roy", "roy", "password", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Utshab", "utshab", "password", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "Bipro", "bipro", "password", new ArrayList<>()));

//            // adding role to users
            userService.addRoleToUser("jhon", "ROLE_USER");
            userService.addRoleToUser("roy", "ROLE_USER");
            userService.addRoleToUser("roy", "ROLE_MANAGER");
            userService.addRoleToUser("roy", "ROLE_ADMIN");
            userService.addRoleToUser("utshab", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("bipro", "ROLE_MANAGER");
            userService.addRoleToUser("bipro", "ROLE_USER");

        };
    }

}
