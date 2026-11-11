package allatmenhelyNyilvantartas.allatMenhely.service.mapper;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.GondAllatKapcsEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.GondAllatKapcsDisplayDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GondAllatKapcsMapper {

   @Mapping(target = "dolgozoId", source = "dolgozo.id")
   @Mapping(target = "animalId", source = "animal.id")
   GondAllatKapcsDisplayDto entityToDto(GondAllatKapcsEnti kapcsolat);

   List<GondAllatKapcsDisplayDto> entityListToDtoList(List<GondAllatKapcsEnti> kapcsolat);
}
