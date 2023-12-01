package ru.liga.tinder.server.anketa.controller.dto.response;

import lombok.Data;
import ru.liga.tinder.server.anketa.service.model.enums.GenderType;
import ru.liga.tinder.server.anketa.service.model.enums.PreferencesType;

import java.time.Instant;
import java.util.UUID;

@Data
public class AnketaRsDto {
    private UUID id;

    private UUID userId;

    private GenderType gender;

    private String name;

    private String header;

    private String description;

    private PreferencesType preferences;

    private Instant createdAt;

    private Instant updatedAt;
}
