package ru.liga.tinder.server.anketa.controller.dto.mappers;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Sort;
import ru.liga.tinder.server.anketa.controller.dto.request.CreateAnketaRqDto;
import ru.liga.tinder.server.anketa.controller.dto.request.FetchAnketaRqDto;
import ru.liga.tinder.server.anketa.controller.dto.request.SearchAnketaRqDto;
import ru.liga.tinder.server.anketa.controller.dto.request.SearchFavoritesRqDto;
import ru.liga.tinder.server.anketa.controller.dto.shared.PageDataRqDto;
import ru.liga.tinder.server.anketa.dao.entity.AnketaEntity;
import ru.liga.tinder.server.anketa.service.model.search.AnketasFilter;
import ru.liga.tinder.server.anketa.service.model.search.LikesFilter;
import ru.liga.tinder.server.anketa.service.model.search.PageData;

@Mapper(componentModel = "spring")
public interface DtoToModelMapper {
    AnketaEntity mapAnketa(CreateAnketaRqDto createAnketaRqDto);
    AnketasFilter mapAnketasFilter(FetchAnketaRqDto fetchAnketaRqDto);

    LikesFilter mapLikesFilter(SearchFavoritesRqDto searchFavoritesRqDto);

    PageData mapPageData(PageDataRqDto pageDataRqDto);

    default Sort mapLikesSort(SearchFavoritesRqDto searchFavoritesRqDto) {
        return null;
    }
    default Sort mapAnketasSort(FetchAnketaRqDto fetchAnketaRqDto) {
        return null;
    }
}
