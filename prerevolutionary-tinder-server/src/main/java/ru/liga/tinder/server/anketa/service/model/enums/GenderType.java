package ru.liga.tinder.server.anketa.service.model.enums;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum GenderType {
    MALE("male"),
    FEMALE("female");

    private final String code;

    @NotNull
    public static GenderType byCode(String code) {
        return Arrays.stream(values())
                .filter(genderType -> genderType.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(GenderType.class, code));
    }
}
