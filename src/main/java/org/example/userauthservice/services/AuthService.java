package org.example.userauthservice.services;

import org.example.userauthservice.models.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    @Override
    public User signup(String name, String email, String password, String phoneNumber) {
        return null;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    public Boolean validateToken(String token, Long userId) {
        return null;
    }
}
