package ru.liga.tinder.server.anketa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.liga.tinder.server.anketa.dao.entity.AnketaEntity;
import ru.liga.tinder.server.anketa.service.model.search.AnketasFilter;

import java.util.Optional;
import java.util.UUID;

public interface AnketasRepository {
    void save(AnketaEntity anketaEntity);

    Optional<AnketaEntity> findByUserId(UUID userId);

    Page<AnketaEntity> findUsersPage(AnketasFilter anketasFilter, Pageable pageable);
}
