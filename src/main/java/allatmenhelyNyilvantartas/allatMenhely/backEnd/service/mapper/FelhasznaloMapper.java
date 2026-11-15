package allatmenhelyNyilvantartas.allatMenhely.backEnd.service.mapper;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.FelhasznaloEnti;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.display.FelhasznaloDisplayDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FelhasznaloMapper {

    @Mapping(target = "dolgozoId", source = "dolgozo.id")
    @Mapping(target = "befogadoId", source = "befogado.id")
    FelhasznaloDisplayDto entityToDto(FelhasznaloEnti felhasznalo);
}
