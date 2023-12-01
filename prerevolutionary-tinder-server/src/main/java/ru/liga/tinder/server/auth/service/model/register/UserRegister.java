package ru.liga.tinder.server.auth.service.model.register;

import lombok.Data;
import ru.liga.tinder.server.auth.service.model.enums.UserType;

@Data
public abstract class UserRegister {
    protected UserType userType;
}
