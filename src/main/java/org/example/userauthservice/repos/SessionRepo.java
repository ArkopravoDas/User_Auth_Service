package org.example.userauthservice.repos;

import org.example.userauthservice.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepo extends JpaRepository<Session, Long> {
    Optional<Session> findByTokenAndUser_Id(String s, Long userId);
}
