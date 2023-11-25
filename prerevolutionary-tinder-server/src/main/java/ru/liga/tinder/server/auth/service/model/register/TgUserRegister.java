package ru.liga.tinder.server.auth.service.model.register;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TgUserRegister extends UserRegister {
    private String telegramId;
}
