package ru.liga.tinder.server.auth.dao;

import java.util.Optional;
import java.util.UUID;

public interface TelegramUsersRepository {
    Optional<UUID> findUserIdByTelegramId(String telegramId);
}
