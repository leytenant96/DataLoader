package com.example.project.controller.user;

import com.example.project.module.Result;
import com.example.project.poyload.user.LoginPayload;
import com.example.project.service.user.imp.LoginServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/username/")
@RequiredArgsConstructor
public class LoginController {
    private final LoginServiceImplement loginServiceImplement;


    @PostMapping("")
    public ResponseEntity<?> saveUsername(@RequestBody LoginPayload loginPayload) {
        Result result = loginServiceImplement.saveUsername(loginPayload);

        if (result.getObject() != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUserName(@PathVariable Long id) {
        Result result = loginServiceImplement.getUsername(id);

        if (result.getObject() != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @GetMapping("")
    public ResponseEntity<?> allUsername() {
        Result result = loginServiceImplement.getAllUser();

        if (result.getObject() != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateUsername(@PathVariable Long id, @RequestBody LoginPayload loginPayload){
        Result result=loginServiceImplement.updateUsername(id,loginPayload);

        if (result.getObject() != null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        } else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
    }
}
