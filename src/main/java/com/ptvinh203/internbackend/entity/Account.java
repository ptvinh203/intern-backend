package com.ptvinh203.internbackend.entity;

import com.ptvinh203.internbackend.util.base_model.AbstractEntity;
import com.ptvinh203.internbackend.util.enums.SystemRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Account extends AbstractEntity {
    @Id
    @GeneratedValue
    private UUID accountId;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private SystemRole role;
    @Column(nullable = false)
    private boolean accountStatus;
    private Timestamp deletedAt;
    private String refreshToken;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(role.getValue()));
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    // Account is active or inactive
//    @Override
//    public boolean isEnabled() {
//        return deletedAt == null;
//    }
}
