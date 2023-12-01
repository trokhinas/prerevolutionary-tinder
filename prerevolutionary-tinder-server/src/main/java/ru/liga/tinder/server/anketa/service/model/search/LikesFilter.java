package ru.liga.tinder.server.anketa.service.model.search;

import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
public class LikesFilter {
    List<UUID> initiatorId;
    List<UUID> targetId;
}
