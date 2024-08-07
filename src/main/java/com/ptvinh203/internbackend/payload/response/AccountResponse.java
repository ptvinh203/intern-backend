package com.ptvinh203.internbackend.payload.response;

import com.ptvinh203.internbackend.util.base_model.AbstractEntity;
import com.ptvinh203.internbackend.util.enums.SystemRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
public class AccountResponse extends AbstractEntity {
    private UUID accountId;
    private String email;
    private SystemRole role;
    private boolean accountStatus;
    private Timestamp deletedAt;
    private String refreshToken;
}
