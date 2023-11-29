package ru.liga.tinder.server.anketa.controller.dto.request;

import lombok.Data;
import ru.liga.tinder.server.anketa.controller.dto.shared.PageDataRqDto;

import java.util.UUID;

@Data
public class SearchFavoritesRqDto {
    //todo убрать передачу userId, заменить на SecurityContext
    private UUID userId;
    private PageDataRqDto pageData;
}
