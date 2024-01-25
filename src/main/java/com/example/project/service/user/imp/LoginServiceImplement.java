package com.example.project.service.user.imp;

import com.example.project.entity.user.Login;
import com.example.project.module.Result;
import com.example.project.poyload.user.LoginPayload;
import com.example.project.repository.user.LoginRepository;
import com.example.project.service.user.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginServiceImplement implements LoginService {
    private final RoleServiceImplement roleServiceImplement;
    private final UserServiceImplement userServiceImplement;
    private final LoginRepository loginRepository;
    private final Result result;

    @Override
    public Result saveUsername(LoginPayload loginPayload) {
        try {
            Login login = Login.builder()
                    .username(loginPayload.getUsername())
                    .password(loginPayload.getPassword())
                    .roleList(roleServiceImplement.saveRoleUser())
                    .userList(userServiceImplement.newUser())
                    .build();
            loginRepository.save(login);
            return result.success(login);
        } catch (Exception e) {
            log.error(e.getMessage());
            return result.failed(e.getMessage());
        }
    }

    @Override
    public Result getAllUser() {
        List<Login> loginList = new ArrayList<>();
        try {
            return result.success(loginRepository.findAll());
        } catch (Exception e) {
            log.error(e.getMessage());
            return result.failed(e.getMessage());
        }
    }

    @Override
    public Login deleteUser(Long id) {
        return null;
    }

    @Override
    public Result updateUsername(Long id, LoginPayload loginPayload) {
        try {
            if (loginRepository.existsById(id)) {
                Login login = Login.builder()
                        .username(loginPayload.getUsername())
                        .password(loginPayload.getPassword())
                        .build();
                loginRepository.save(login);
                return result.success(login);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return result.failed(e.getMessage());
        }
        return null;
    }

    public Result getUsername(Long id) {
        Login login = loginRepository.findById(id).orElse(null);
        return result.success(login);
    }
}
