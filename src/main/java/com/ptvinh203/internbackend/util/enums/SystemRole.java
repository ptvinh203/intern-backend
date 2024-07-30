package com.ptvinh203.internbackend.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SystemRole implements AbstractEnum<SystemRole> {
    ADMIN("admin"),
    USER("user");

    private final String value;
    private final String enumName = this.name();
}
