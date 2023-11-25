package ru.liga.tinder.server.auth.controller.dto.register;

import lombok.Data;
import ru.liga.tinder.server.auth.service.model.enums.UserType;

@Data
public abstract class RegisterRqDto {
    protected UserType userType;
}
