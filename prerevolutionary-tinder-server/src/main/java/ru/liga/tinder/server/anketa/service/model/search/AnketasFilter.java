package ru.liga.tinder.server.anketa.service.model.search;

import lombok.Value;
import ru.liga.tinder.server.anketa.service.model.enums.GenderType;
import ru.liga.tinder.server.anketa.service.model.enums.PreferencesType;

import java.util.List;
import java.util.UUID;

@Value
public class AnketasFilter {
    List<GenderType> genderTypes;
    List<PreferencesType> preferencesTypes;
    List<UUID> excludeUserIds;
    List<UUID> includeUserIds;
}
