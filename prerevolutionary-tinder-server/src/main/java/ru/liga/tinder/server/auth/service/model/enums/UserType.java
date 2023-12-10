package ru.liga.tinder.server.auth.service.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserType {
    TELEGRAM("tg");

    private final String code;
}
