package ru.liga.tinder.server.auth.service;

import ru.liga.tinder.server.auth.controller.dto.auth.AuthRqDto;
import ru.liga.tinder.server.auth.service.model.auth.UserAuth;

public interface Mapper<Dto, Model> {
    Model fromDtoToModel(Dto dto);

    Dto fromModelToDto(Model model);
}
