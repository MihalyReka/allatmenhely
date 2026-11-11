package allatmenhelyNyilvantartas.allatMenhely.service.mapper;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.AnimalEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.AnimalCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.AnimalDisplayDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.AnimalTeljesLekeresDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

//    // Entity -> teljes DTO (dolgozói lekérdezés)

//    @Mapping(target = "adopterId", source = "adopter.id")
//    AnimalCrudDto entityToDto(AnimalEnti animal);
//
//    // Entity lista -> teljes DTO lista (dolgozói lekérdezés)
//    List<AnimalCrudDto> entityListToDtoList(List<AnimalEnti> animals);
    // Entity -> teljes DTO (dolgozói lekérdezés)

    @Mapping(target = "adopterId", source = "adopter.id")
    AnimalTeljesLekeresDto entityToDto(AnimalEnti animal);

    // Entity lista -> teljes DTO lista (dolgozói lekérdezés)
    List<AnimalTeljesLekeresDto> entityListToDtoList(List<AnimalEnti> animals);

    // Entity -> nyilvános DTO
    AnimalDisplayDto entityToPublicDto(AnimalEnti animal);

    // Entity lista -> nyilvános DTO lista
    List<AnimalDisplayDto> entityListToPublicDtoList(List<AnimalEnti> animals);

    // DTO -> Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "adopter", ignore = true)
    AnimalEnti dtoToEntity(AnimalCrudDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "adopter", ignore = true)
    void updateEntityFromDto(AnimalCrudDto dto, @MappingTarget AnimalEnti entity);
}
