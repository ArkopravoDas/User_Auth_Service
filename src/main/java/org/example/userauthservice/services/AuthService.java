package org.example.userauthservice.services;

import org.example.userauthservice.exceptions.PasswordMismatchException;
import org.example.userauthservice.exceptions.UserAlreadyExistsException;
import org.example.userauthservice.exceptions.UserNotSignedUpException;
import org.example.userauthservice.models.User;
import org.example.userauthservice.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User signup(String name, String email, String password, String phoneNumber) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if(userOptional.isPresent()) {
            throw new UserAlreadyExistsException("Please login directly");
        }

        User user = new User();
        user.setEmail(email);
//        user.setPassword(password);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        return userRepo.save(user);
    }

    @Override
    public User login(String email, String password) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if(userOptional.isEmpty()) {
            throw new UserNotSignedUpException("Please create your account first");
        }

        User user = userOptional.get();

        if(!bCryptPasswordEncoder.matches(password,user.getPassword())) {
            throw new PasswordMismatchException("Passwords didn't match");
        }

        return user;
    }

    @Override
    public Boolean validateToken(String token, Long userId) {
        return null;
    }
}
