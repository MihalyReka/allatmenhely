package allatmenhelyNyilvantartas.allatMenhely.backEnd.service;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.AnimalCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.AnimalTeljesLekeresDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.display.AnimalDisplayDto;

import java.util.List;

public interface AnimalService {

    List<AnimalTeljesLekeresDto> getAllAnimals();

    List<AnimalDisplayDto> getAllPublicAnimals();

    AnimalTeljesLekeresDto createAnimal(AnimalCrudDto animalCrudDto);

    AnimalTeljesLekeresDto updateAnimal(Long id, AnimalCrudDto animalCrudDto);

    void deleteAnimal(Long id);

    AnimalTeljesLekeresDto getAnimalById(Long id);
    AnimalDisplayDto getPublicAnimalById(Long id);


}
