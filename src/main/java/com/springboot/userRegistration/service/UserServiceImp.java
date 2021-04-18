package com.springboot.userRegistration.service;

import com.springboot.userRegistration.model.Roles;
import com.springboot.userRegistration.model.User;
import com.springboot.userRegistration.repository.RoleRepository;
import com.springboot.userRegistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus("VERIFIED");
        Roles userRole = roleRepository.findByRole("SITE_USER");
        user.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public boolean isUserPresent(User user) {
        boolean userExists = false;
        User existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser!=null){
            userExists = true;
        }
        return userExists;
    }
}
