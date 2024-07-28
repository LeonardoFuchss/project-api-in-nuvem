package me.dio.service;

import me.dio.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUser();
    User getById(Integer id);
    void updateUser(Integer id, User user);
    void deleteUserById(Integer id);


}
