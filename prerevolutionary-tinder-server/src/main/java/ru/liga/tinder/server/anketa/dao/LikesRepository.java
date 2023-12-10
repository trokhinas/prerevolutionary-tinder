package ru.liga.tinder.server.anketa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.liga.tinder.server.anketa.service.model.search.LikesFilter;
import ru.liga.tinder.server.anketa.dao.entity.LikeEntity;

public interface LikesRepository {
    void save(LikeEntity likeEntity);

    boolean exists(LikeEntity likeEntity);

    /*
    TODO
    A likes B - на 1 странице => вернем взаимность A и B
    B likes A - на 10 странице => вернем взаимность A и B
    при пагинации может вернуть по-сути одну и ту же анкету второй раз
     */
    Page<LikeEntity> getLikes(LikesFilter likesFilter, Pageable pageable);
}
