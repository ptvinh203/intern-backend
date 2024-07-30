package com.ptvinh203.internbackend.util.enums;


import com.ptvinh203.internbackend.util.exception.InternalServerException;

public interface AbstractEnum<T> {
    String getEnumName();

    String getValue();

    static <T extends AbstractEnum<T>> T fromString(T[] values, String value) {
        for (T v : values)
            if (v.getValue().equalsIgnoreCase(value))
                return v;
        throw new InternalServerException("Invalid enum value: %s - %s".formatted(value, values[0].getClass().getSimpleName()));
    }
}
