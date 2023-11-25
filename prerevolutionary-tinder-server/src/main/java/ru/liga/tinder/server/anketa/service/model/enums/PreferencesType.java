package ru.liga.tinder.server.anketa.service.model.enums;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum PreferencesType {
    MALE("male"),
    FEMALE("female"),
    ANY("any");

    private final String code;

    @NotNull
    public static PreferencesType byCode(String code) {
        return Arrays.stream(values())
                .filter(preferencesType -> preferencesType.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(PreferencesType.class, code));
    }
}
