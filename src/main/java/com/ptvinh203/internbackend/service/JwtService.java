package com.ptvinh203.internbackend.service;

import com.ptvinh203.internbackend.payload.response.CredentialResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    UserDetails getAccountFromToken(String token);

    CredentialResponse generateToken(String accountId);

    CredentialResponse refreshToken(String refreshToken, boolean isAdmin);
}
