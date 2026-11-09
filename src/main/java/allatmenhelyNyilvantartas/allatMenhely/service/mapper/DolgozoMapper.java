package allatmenhelyNyilvantartas.allatMenhely.service.mapper;


import allatmenhelyNyilvantartas.allatMenhely.data.entity.DolgozoEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.DolgozoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.DolgozoDisplayDto;
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


}
