package ru.liga.tinder.server.auth.controller.dto.auth;

import lombok.Data;
import ru.liga.tinder.server.auth.service.model.enums.UserType;

@Data
public abstract class AuthRqDto {
    protected UserType userType;
}
