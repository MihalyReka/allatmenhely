package allatmenhelyNyilvantartas.allatMenhely.service.mapper;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.AnimalEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.AnimalCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.AnimalDisplayDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    // Entity -> teljes DTO
    @Mapping(target = "helyszinId", source = "helyszin.id")
    @Mapping(target = "adopterId", source = "adopter.id")
    AnimalCrudDto entityToDto(AnimalEnti animal);

    // Entity lista -> teljes DTO lista
    List<AnimalCrudDto> entityListToDtoList(List<AnimalEnti> animals);

    // Entity -> nyilvános DTO
    AnimalDisplayDto entityToPublicDto(AnimalEnti animal);

    // Entity lista -> nyilvános DTO lista
    List<AnimalDisplayDto> entityListToPublicDtoList(List<AnimalEnti> animals);

    // DTO -> Entity
    @Mapping(target = "id", ignore = true)
    AnimalEnti dtoToEntity(AnimalCrudDto dto);
}
