package allatmenhelyNyilvantartas.allatMenhely.service.mapper;


import allatmenhelyNyilvantartas.allatMenhely.data.entity.BefogadoEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.BefogadoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.BefogadoTeljesLekeresDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.BefogadoDisplayDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BefogadoMapper {

    BefogadoTeljesLekeresDto entityToDto(BefogadoEnti befogado);

    List<BefogadoTeljesLekeresDto> entityListToDtoList(List<BefogadoEnti> befogadok);

    BefogadoDisplayDto entityToDisplayDto(BefogadoEnti befogado);

    List<BefogadoDisplayDto> entityListToDisplayDtoList(List<BefogadoEnti> befogadok);

    @Mapping(target = "id", ignore = true)
    BefogadoEnti dtoToEntity(BefogadoCrudDto dto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(BefogadoCrudDto dto, @MappingTarget BefogadoEnti entity);



}
