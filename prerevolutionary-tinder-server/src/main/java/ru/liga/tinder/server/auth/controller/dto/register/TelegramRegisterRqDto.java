package ru.liga.tinder.server.auth.controller.dto.register;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TelegramRegisterRqDto extends RegisterRqDto {
    private String telegramId;
}
