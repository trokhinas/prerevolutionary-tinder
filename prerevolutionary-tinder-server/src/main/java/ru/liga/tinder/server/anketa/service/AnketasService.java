package ru.liga.tinder.server.anketa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import ru.liga.tinder.server.anketa.dao.entity.AnketaEntity;
import ru.liga.tinder.server.anketa.service.model.search.AnketasFilter;
import ru.liga.tinder.server.anketa.service.model.search.PageData;

import java.util.Optional;
import java.util.UUID;

public interface AnketasService {
    AnketaEntity create(AnketaEntity anketaEntity);

    Optional<AnketaEntity> findUserAnketa(UUID userId);

    Page<AnketaEntity> search(UUID userId, PageData pageData);

    Page<AnketaEntity> fetch(AnketasFilter anketasFilter, PageData pageData, Sort sort);
}
