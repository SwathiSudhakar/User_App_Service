package com.app.userservice.service.user;

import com.app.userservice.entity.User;
import com.app.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(final User user) {
        //TODO Add validation
        return userRepository.save(user);
    }

    public List<User> fetchAll() {
        return userRepository.findAll();
    }
    
    public void generateDummyUser() {
    	List<User> dummyUser=new ArrayList<>();
    
    }
}
