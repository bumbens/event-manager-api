package com.example.eventmanager.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User updateUser){
        User user = userRepository.findById(id).orElseThrow(() -> new NullPointerException());
        user.setName(updateUser.getName());
        user.setEmail(updateUser.getEmail());
        return userRepository.save(user);
    }
}
