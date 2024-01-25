package com.example.project.repository.user;

import com.example.project.entity.user.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
