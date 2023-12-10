package ru.liga.tinder.server.auth.service.model.auth;

import lombok.Data;
import ru.liga.tinder.server.auth.service.model.enums.UserType;

@Data
public abstract class UserAuth {
    protected UserType userType;
}
