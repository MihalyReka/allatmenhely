package allatmenhelyNyilvantartas.allatMenhely.backEnd.service.mapper;


import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.DolgozoEnti;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.DolgozoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.display.DolgozoDisplayDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DolgozoMapper {


    DolgozoDisplayDto entityToDto(DolgozoEnti dolgozo);
    List<DolgozoDisplayDto> entityListToDtoList(List<DolgozoEnti> dolgozo);
    @Mapping(target = "id", ignore = true)
    DolgozoEnti dtoToEntity(DolgozoCrudDto dto);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(DolgozoCrudDto dto, @MappingTarget DolgozoEnti dolgozo);


    DolgozoCrudDto entityToDisplayDto(DolgozoEnti dolgozo);
}
