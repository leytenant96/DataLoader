package com.example.project.poyload.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPayload {
    String firstName;
    String lastName;
    String phoneNumber;
}
