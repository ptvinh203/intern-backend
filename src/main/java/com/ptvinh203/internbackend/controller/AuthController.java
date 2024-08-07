package com.ptvinh203.internbackend.controller;

import com.ptvinh203.internbackend.entity.Account;
import com.ptvinh203.internbackend.mapper.AccountMapper;
import com.ptvinh203.internbackend.util.enums.SystemRole;
import com.ptvinh203.internbackend.util.util.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AccountMapper accountMapper;

    @GetMapping("/hello-world")
    public String helloWorld() {
        var account = Account.builder()
                .accountId(UUID.randomUUID())
                .email("@gmail.com")
                .password("password")
                .accountStatus(true)
                .role(SystemRole.USER)
                .build();
        var accountResponse = accountMapper.toResponse(account);
        return "Hello World!" + CommonUtils.convertToJson(accountResponse);
    }
}
