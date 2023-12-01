package ru.liga.tinder.server.anketa.controller.dto.request;

import lombok.Data;
import ru.liga.tinder.server.anketa.controller.dto.shared.PageDataRqDto;
import ru.liga.tinder.server.anketa.service.model.enums.PreferencesType;

import java.util.List;
import java.util.UUID;

@Data
public class FetchAnketaRqDto {
    private List<UUID> userId;
    private PageDataRqDto pageData;
}
