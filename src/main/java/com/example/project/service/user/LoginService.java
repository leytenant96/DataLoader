package com.example.project.service.user;

import com.example.project.entity.user.Login;
import com.example.project.module.Result;
import com.example.project.poyload.user.LoginPayload;

public interface LoginService {
    Result saveUsername(LoginPayload loginPayload);

    Result getAllUser();

    Login deleteUser(Long id);

    Result updateUsername(Long id, LoginPayload loginPayload);
}
