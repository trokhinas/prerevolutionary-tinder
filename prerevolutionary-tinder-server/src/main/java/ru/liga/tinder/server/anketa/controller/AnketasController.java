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
import ru.liga.tinder.server.anketa.controller.dto.request.CreateAnketaRqDto;
import ru.liga.tinder.server.anketa.controller.dto.request.FetchAnketaRqDto;
import ru.liga.tinder.server.anketa.controller.dto.request.SearchAnketaRqDto;
import ru.liga.tinder.server.anketa.controller.dto.response.AnketaRsDto;
import ru.liga.tinder.server.anketa.controller.dto.shared.SearchRsDto;
import ru.liga.tinder.server.anketa.dao.entity.AnketaEntity;
import ru.liga.tinder.server.anketa.service.AnketasService;
import ru.liga.tinder.server.anketa.service.model.search.AnketasFilter;
import ru.liga.tinder.server.anketa.service.model.search.PageData;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequestMapping("api/anketas")
@RequiredArgsConstructor
public class AnketasController {
    private final AnketasService anketasService;

    private final DtoToModelMapper dtoToModelMapper;
    private final ModelToDtoMapper modelToDtoMapper;

    @PostMapping
    public ResponseEntity<AnketaRsDto> create(CreateAnketaRqDto createAnketaRqDto) {
        final AnketaEntity anketaEntity = anketasService.create(dtoToModelMapper.mapAnketa(createAnketaRqDto));
        return ResponseEntity.ok(modelToDtoMapper.mapAnketa(anketaEntity));
    }

    //todo убрать передачу userId, заменить на SecurityContext
    @GetMapping
    public ResponseEntity<AnketaRsDto> getUserAnketa(UUID userId) {
        final Optional<AnketaEntity> anketaEntity = anketasService.findUserAnketa(userId);
        return ResponseEntity.of(anketaEntity.map(modelToDtoMapper::mapAnketa));
    }

    /**
     * Реализация поискового движка приложения. Имеет свою логику, применения правил фильтрации и т.д., которая
     * сконцентрирована на сервере и является общей для всех возможных клиентов.
     * @param searchAnketaRqDto
     * @return
     */
    @GetMapping("search")
    public ResponseEntity<SearchRsDto<AnketaRsDto>> searchAnketas(SearchAnketaRqDto searchAnketaRqDto) {
        final PageData pageData = dtoToModelMapper.mapPageData(searchAnketaRqDto.getPageData());
        final Page<AnketaRsDto> anketas = anketasService.search(searchAnketaRqDto.getUserId(), pageData).map(modelToDtoMapper::mapAnketa);

        return ResponseEntity.ok(SearchRsDto.fromPage(anketas));
    }

    /**
     * "Тупой" метод получения анкет, следующий строго переданным параметрам фильтрации. Разным клиентам может требоваться
     * разное количество анкет на интерфейсе, например.
     * @param fetchAnketaRqDto
     * @return
     */
    @GetMapping("fetch")
    public ResponseEntity<SearchRsDto<AnketaRsDto>> fetchAnketas(FetchAnketaRqDto fetchAnketaRqDto) {
        final AnketasFilter anketasFilter = dtoToModelMapper.mapAnketasFilter(fetchAnketaRqDto);
        final PageData pageData = dtoToModelMapper.mapPageData(fetchAnketaRqDto.getPageData());
        final Sort sort = dtoToModelMapper.mapAnketasSort(fetchAnketaRqDto);
        final Page<AnketaRsDto> anketas = anketasService.fetch(anketasFilter, pageData, sort).map(modelToDtoMapper::mapAnketa);

        return ResponseEntity.ok(SearchRsDto.fromPage(anketas));
    }
}
