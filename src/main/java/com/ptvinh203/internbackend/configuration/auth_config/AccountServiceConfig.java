//package com.ptvinh203.internbackend.configuration.auth_config;
//
//import com.ptvinh203.internbackend.repository.AccountRepository;
//import com.ptvinh203.internbackend.util.constant.ErrorMessageConstant;
//import com.ptvinh203.internbackend.util.exception.NotFoundObjectException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@RequiredArgsConstructor
//public class AccountServiceConfig {
//    private final AccountRepository repo;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return email -> {
//            if (email != null && !email.isBlank()) {
//                return repo.findByEmail(email)
//                        .orElseThrow(() -> new NotFoundObjectException(ErrorMessageConstant.ACCOUNT_NOT_FOUND));
//            }
//            throw new NotFoundObjectException(ErrorMessageConstant.ACCOUNT_NOT_FOUND);
//        };
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//}
