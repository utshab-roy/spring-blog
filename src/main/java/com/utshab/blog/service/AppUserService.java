package com.utshab.blog.service;

import com.utshab.blog.models.AppUser;
import com.utshab.blog.models.Role;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    AppUser getUser(String username);

    List<AppUser> getUsers();

    Optional<AppUser> getUserById(long id);
}
