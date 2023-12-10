package ru.liga.tinder.server.anketa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import ru.liga.tinder.server.anketa.service.model.Favorite;
import ru.liga.tinder.server.anketa.service.model.search.LikesFilter;
import ru.liga.tinder.server.anketa.service.model.search.PageData;

import java.util.UUID;

public interface LikesService {
    boolean like(UUID userId, UUID targetId);

    Page<Favorite> searchFavoritesPage(LikesFilter likesFilter, PageData pageData, Sort sort);
}
