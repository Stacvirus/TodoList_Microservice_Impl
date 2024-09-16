package com.stac.history_service.mapper;

import com.stac.history_service.dto.HistoryDto;
import com.stac.history_service.entity.History;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.ZonedDateTime;

@Mapper(componentModel = "spring", imports = {ZonedDateTime.class})
public interface HistoryMapper {
    HistoryDto toDto(History history);

    @Mapping(target = "createdAt", defaultExpression = "java(ZonedDateTime.now())")
    History toEntity(HistoryDto historyDto);
}
