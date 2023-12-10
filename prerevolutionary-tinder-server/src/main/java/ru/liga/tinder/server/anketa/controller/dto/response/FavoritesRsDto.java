package ru.liga.tinder.server.anketa.controller.dto.response;

import lombok.Data;
import ru.liga.tinder.server.anketa.service.model.enums.LikeRelationship;

import java.util.UUID;

@Data
public class FavoritesRsDto {
    private UUID favoriteUserId;
    private LikeRelationship likeRelationship;
}
