package allatmenhelyNyilvantartas.allatMenhely.service;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.AnimalEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.AnimalCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.AnimalTeljesLekeresDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.AnimalDisplayDto;

import java.util.List;

public interface AnimalService {

    List<AnimalTeljesLekeresDto> getAllAnimals();

    List<AnimalDisplayDto> getAllPublicAnimals();

    AnimalTeljesLekeresDto createAnimal(AnimalCrudDto animalCrudDto);

    AnimalTeljesLekeresDto updateAnimal(Long id, AnimalCrudDto animalCrudDto);


}
