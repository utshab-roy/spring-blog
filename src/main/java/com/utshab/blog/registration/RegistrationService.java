package com.utshab.blog.registration;

import com.utshab.blog.appuser.AppUser;
import com.utshab.blog.appuser.AppUserRole;
import com.utshab.blog.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("Not valid email");
        }

        return appUserService.signUpUser(
          new AppUser(
                  request.getFirstName(),
                  request.getLastName(),
                  request.getEmail(),
                  request.getPassword(),
                  AppUserRole.USER
          )
        );

    }
}
