package com.example.project.entity.user;

import com.example.project.entity.AbstractHelper;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
@Entity(name = "users")
public class User extends AbstractHelper {
    String firstName;
    String lastName;
    String phoneNumber;
    boolean isDelete = false;
}
