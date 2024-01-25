package com.example.project.service.user;

import com.example.project.entity.user.User;
import com.example.project.poyload.user.UserPayload;

public interface UserService {
    User saveUser(UserPayload userPayload);

    User daleteUser(Long id);

    User getUser(Long id);

    User updateUser(Long id);
}
