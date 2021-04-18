package com.springboot.userRegistration.service;

import com.springboot.userRegistration.model.User;

public interface UserService {
    public void saveUser(User user);
    public boolean isUserPresent(User user);
}
