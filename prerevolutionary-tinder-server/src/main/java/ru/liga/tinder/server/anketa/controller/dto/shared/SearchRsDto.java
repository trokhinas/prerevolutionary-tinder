package ru.liga.tinder.server.anketa.controller.dto.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
public class SearchRsDto<T> {
    private List<T> data;
    private PageDataRsDto pageData;

    public static <T> SearchRsDto<T> fromPage(Page<T> page) {
        final PageDataRsDto pageDataRsDto = new PageDataRsDto();
        //todo page is zero-based, but users search could be is one-based
        pageDataRsDto.setNumber(page.getNumber());
        pageDataRsDto.setSize(page.getSize());
        pageDataRsDto.setTotal(page.getTotalPages());

        return new SearchRsDto<>(page.getContent(), pageDataRsDto);
    }
}
