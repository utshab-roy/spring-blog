package com.utshab.blog.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    // this will find the token by passing string token
    Optional<ConfirmationToken> findByToken(String token);
}
