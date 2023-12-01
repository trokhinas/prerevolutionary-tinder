package ru.liga.tinder.server.anketa.controller.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class LikeRqDto {
    //todo убрать передачу userId, заменить на SecurityContext
    private UUID userId;
    private UUID targetId;
}
