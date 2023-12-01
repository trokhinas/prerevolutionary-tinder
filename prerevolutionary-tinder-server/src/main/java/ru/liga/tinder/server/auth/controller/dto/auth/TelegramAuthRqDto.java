package ru.liga.tinder.server.auth.controller.dto.auth;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TelegramAuthRqDto extends AuthRqDto {
    private String telegramId;
}
