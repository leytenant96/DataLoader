package com.example.project.entity.user;

import com.example.project.entity.AbstractHelper;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
@Entity
public class Login extends AbstractHelper {
    @Column(unique = true)
    String username;
    String password;

    @OneToMany
    List<Role> roleList;

    @OneToMany
    List<User> userList;
}
