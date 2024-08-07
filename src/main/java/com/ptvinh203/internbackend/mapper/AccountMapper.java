package com.ptvinh203.internbackend.mapper;

import com.ptvinh203.internbackend.configuration.SpringMapStructConfig;
import com.ptvinh203.internbackend.entity.Account;
import com.ptvinh203.internbackend.payload.response.AccountResponse;
import org.mapstruct.Mapper;

@Mapper(config = SpringMapStructConfig.class)
public interface AccountMapper {
    AccountResponse toResponse(Account account);
}
