package allatmenhelyNyilvantartas.allatMenhely.service.mapper;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.FelhasznaloEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.FelhasznaloDisplayDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FelhasznaloMapper {

    @Mapping(target = "dolgozoId", source = "dolgozo.id")
    @Mapping(target = "befogadoId", source = "befogado.id")
    FelhasznaloDisplayDto entityToDto(FelhasznaloEnti felhasznalo);
}
