package ru.liga.tinder.server.anketa.dao.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class LikeEntity {
    private UUID initiatorId;

    private UUID targetId;
}
