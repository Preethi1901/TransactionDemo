package com.example.demo.Services;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("User already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User loginUser(User userInput){
       User userfromdb= userRepository.findByEmail(userInput.getEmail())

                .orElseThrow(()->new RuntimeException("invalid email"));

       if(!passwordEncoder.matches(userInput.getPassword(),userfromdb.getPassword() )){
           throw  new RuntimeException("invalid password");
       }
       return userfromdb;
    }

}
