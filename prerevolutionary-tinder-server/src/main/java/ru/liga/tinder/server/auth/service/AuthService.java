package ru.liga.tinder.server.auth.service;

import ru.liga.tinder.server.auth.controller.dto.auth.AuthRqDto;
import ru.liga.tinder.server.auth.controller.dto.register.RegisterRqDto;
import ru.liga.tinder.server.auth.service.model.auth.UserAuth;
import ru.liga.tinder.server.auth.service.model.enums.UserType;
import ru.liga.tinder.server.auth.service.model.register.UserRegister;

import java.util.Optional;
import java.util.UUID;

public interface AuthService {
    Optional<UUID> getUser(UserAuth userAuth);

    boolean checkUser(UUID id);

    UUID register(UserRegister userRegister);

    Mapper<AuthRqDto, UserAuth> getAuthMapper(UserType userType);

    Mapper<RegisterRqDto, UserRegister> getRegisterMapper(UserType userType);

}
