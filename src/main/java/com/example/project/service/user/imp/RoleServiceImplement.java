package com.example.project.service.user.imp;

import com.example.project.entity.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImplement {
    public List<Role> saveRoleAdmin() {
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setId(1L);
        role.setName("ROLE_ADMIN");
        roleList.add(role);

        return roleList;
    }

    public List<Role> saveRoleUser() {
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setId(2L);
        role.setName("ROLE_USER");
        roleList.add(role);

        return roleList;
    }
}
