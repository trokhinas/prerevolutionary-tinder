package ru.liga.tinder.server.anketa.controller.dto.request;

import lombok.Data;
import ru.liga.tinder.server.anketa.service.model.enums.GenderType;
import ru.liga.tinder.server.anketa.service.model.enums.PreferencesType;

import java.util.UUID;

@Data
public class CreateAnketaRqDto {
    //todo убрать передачу userId, заменить на SecurityContext
    private UUID userId;

    private GenderType gender;

    private String name;

    private String header;

    private String description;

    private PreferencesType preferences;
}
