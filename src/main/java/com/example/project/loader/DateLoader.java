package com.example.project.loader;

import com.example.project.entity.user.Login;
import com.example.project.entity.user.Role;
import com.example.project.entity.user.User;
import com.example.project.repository.user.LoginRepository;
import com.example.project.repository.user.RoleRepository;
import com.example.project.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
@Slf4j
public class DateLoader implements CommandLineRunner {
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String text;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final LoginRepository loginRepository;

    @Override
    public void run(String... args) throws Exception {

        try {
            if (text.equals("create")) {
                Role roleAdmin = new Role();
                roleAdmin.setId(1L);
                roleAdmin.setName("ROLE_ADMIN");
                roleRepository.save(roleAdmin);

                Role roleUser = new Role();
                roleUser.setId(2L);
                roleUser.setName("ROLE_USER");
                roleRepository.save(roleUser);

                User user = new User();
                user.setId(1L);
                user.setFirstName("Urol");
                user.setLastName("Khujavov");
                user.setPhoneNumber("998933333333");
                user.setDelete(false);
                userRepository.save(user);

                Login login = new Login();
                login.setId(1L);
                login.setUsername("admin");
                login.setPassword("123");
                login.setRoleList(Collections.singletonList(roleAdmin));
                login.setUserList(Collections.singletonList(user));
                loginRepository.save(login);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}
