package ru.liga.tinder.server.auth.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.liga.tinder.server.auth.controller.dto.UserCheckRqDto;
import ru.liga.tinder.server.auth.controller.dto.auth.AuthRqDto;
import ru.liga.tinder.server.auth.controller.dto.register.RegisterRqDto;
import ru.liga.tinder.server.auth.service.AuthService;
import ru.liga.tinder.server.auth.service.Mapper;
import ru.liga.tinder.server.auth.service.model.auth.UserAuth;
import ru.liga.tinder.server.auth.service.model.enums.UserType;
import ru.liga.tinder.server.auth.service.model.register.UserRegister;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("{userType}/auth")
    public ResponseEntity<UUID> authTelegram(@PathVariable UserType userType,
                                             @RequestBody AuthRqDto authRqDto) {
        log.debug("Authorization attempt userType = [{}]", authRqDto.getUserType());
        final Mapper<AuthRqDto, UserAuth> mapper = authService.getAuthMapper(userType);
        final UserAuth userAuth = mapper.fromDtoToModel(authRqDto);

        return authService.getUser(userAuth)
                .map(ResponseEntity::ok)
                .orElseGet(this::unauthorized);
    }

    @PostMapping("{userType}/register")
    public ResponseEntity<UUID> register(@PathVariable UserType userType,
                                         @RequestBody RegisterRqDto registerRqDto) {
        log.debug("Register attempt userType = [{}]", registerRqDto.getUserType());
        final Mapper<RegisterRqDto, UserRegister> mapper = authService.getRegisterMapper(userType);
        final UserRegister userRegister = mapper.fromDtoToModel(registerRqDto);

        return ResponseEntity.ok(authService.register(userRegister));
    }

    @PostMapping("check")
    public ResponseEntity<UUID> checkUser(@RequestBody UserCheckRqDto userCheckRqDto) {
        log.debug("Check user with userId = [{}]", userCheckRqDto.getId());
        return authService.checkUser(userCheckRqDto.getId())
                ? ResponseEntity.ok().build()
                : unauthorized();
    }

    private <T> ResponseEntity<T> unauthorized() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
