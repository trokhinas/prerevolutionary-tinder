package ru.liga.tinder.server.anketa.controller.dto.mappers;

import org.mapstruct.Mapper;
import ru.liga.tinder.server.anketa.controller.dto.response.AnketaRsDto;
import ru.liga.tinder.server.anketa.controller.dto.response.FavoritesRsDto;
import ru.liga.tinder.server.anketa.dao.entity.AnketaEntity;
import ru.liga.tinder.server.anketa.service.model.Favorite;

@Mapper(componentModel = "spring")
public interface ModelToDtoMapper {
    AnketaRsDto mapAnketa(AnketaEntity anketaEntity);

    FavoritesRsDto mapFavorite(Favorite favorite);
}
