package com.example.project.service.user.imp;

import com.example.project.entity.user.User;
import com.example.project.poyload.user.UserPayload;
import com.example.project.repository.user.UserRepository;
import com.example.project.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    public List<User> newUser() {
        List<User> userList = new ArrayList<>();

        User user = new User();
        userRepository.save(user);

        userList.add(user);
        return userList;
    }

    @Override
    public User saveUser(UserPayload userPayload ) {
        try {
            User user = User.builder()
                    .firstName(userPayload.getFirstName())
                    .lastName(userPayload.getLastName())
                    .phoneNumber(userPayload.getPhoneNumber())
                    .build();
            userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public User getUser(Long id) {
        return findById(id);
    }

    @Override
    public User updateUser(Long id) {
        return null;
    }

    @Override
    public User daleteUser(Long id) {
        return null;
    }

    private User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }
}
