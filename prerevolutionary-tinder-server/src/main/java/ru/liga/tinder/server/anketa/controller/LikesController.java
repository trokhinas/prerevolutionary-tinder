package ru.liga.tinder.server.anketa.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.liga.tinder.server.anketa.controller.dto.mappers.DtoToModelMapper;
import ru.liga.tinder.server.anketa.controller.dto.mappers.ModelToDtoMapper;
import ru.liga.tinder.server.anketa.controller.dto.request.LikeRqDto;
import ru.liga.tinder.server.anketa.controller.dto.request.SearchFavoritesRqDto;
import ru.liga.tinder.server.anketa.controller.dto.response.FavoritesRsDto;
import ru.liga.tinder.server.anketa.controller.dto.response.MutualLikeRsDto;
import ru.liga.tinder.server.anketa.controller.dto.shared.SearchRsDto;
import ru.liga.tinder.server.anketa.service.LikesService;
import ru.liga.tinder.server.anketa.service.model.search.LikesFilter;
import ru.liga.tinder.server.anketa.service.model.search.PageData;

@Slf4j
@RequestMapping("api/likes")
@RequiredArgsConstructor
public class LikesController {
    private final LikesService likesService;
    private final DtoToModelMapper dtoToModelMapper;
    private final ModelToDtoMapper modelToDtoMapper;

    @PostMapping
    public ResponseEntity<MutualLikeRsDto> likeAnketa(LikeRqDto likeRqDto) {
        final boolean isMutual = likesService.like(likeRqDto.getUserId(), likeRqDto.getTargetId());
        return ResponseEntity.ok(new MutualLikeRsDto(isMutual));
    }

    @GetMapping("favorites")
    public ResponseEntity<SearchRsDto<FavoritesRsDto>> searchFavorites(SearchFavoritesRqDto searchFavoritesRqDto) {
        final LikesFilter likesFilter = dtoToModelMapper.mapLikesFilter(searchFavoritesRqDto);
        final Sort sort = dtoToModelMapper.mapLikesSort(searchFavoritesRqDto);
        final PageData pageData = dtoToModelMapper.mapPageData(searchFavoritesRqDto.getPageData());
        final Page<FavoritesRsDto> favorites = likesService.searchFavoritesPage(likesFilter, pageData, sort)
                .map(modelToDtoMapper::mapFavorite);

        return ResponseEntity.ok(SearchRsDto.fromPage(favorites));
    }
}
