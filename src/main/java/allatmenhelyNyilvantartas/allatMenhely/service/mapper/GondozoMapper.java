package allatmenhelyNyilvantartas.allatMenhely.service.mapper;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.GondozoEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.GondozoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.GondozoDisplayDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GondozoMapper {

    GondozoDisplayDto entityToDto(GondozoEnti gondozo);

    List<GondozoDisplayDto> entityListToDtoList(List<GondozoEnti> gondozok);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dolgozo", ignore = true)
    GondozoEnti dtoToEntity(GondozoCrudDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dolgozo", ignore = true)
    void updateEntityFromDto(GondozoCrudDto dto, @MappingTarget GondozoEnti gondozo);
}