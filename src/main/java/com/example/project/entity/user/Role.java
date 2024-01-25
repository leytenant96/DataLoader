package com.example.project.entity.user;

import com.example.project.entity.AbstractHelper;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder
@Entity
public class Role extends AbstractHelper implements GrantedAuthority {

    String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
