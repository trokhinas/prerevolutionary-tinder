package ru.liga.tinder.server.anketa.service.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Favorite {
    private UUID userId;
    private Favorite likeRelationship;
}
