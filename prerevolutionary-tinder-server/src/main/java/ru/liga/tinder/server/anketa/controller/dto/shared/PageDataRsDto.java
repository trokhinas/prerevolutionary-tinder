package ru.liga.tinder.server.anketa.controller.dto.shared;

import lombok.Data;

@Data
public class PageDataRsDto {
    private int number;
    private int size;
    private int total;
}
