package ru.liga.tinder.server.auth.service.model.auth;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TgUserAuth extends UserAuth {
    private String telegramId;
}
