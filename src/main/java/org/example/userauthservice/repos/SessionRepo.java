package org.example.userauthservice.repos;

import org.example.userauthservice.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session, Long> {
}
