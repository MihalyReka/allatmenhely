package allatmenhelyNyilvantartas.allatMenhely.service;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.AnimalEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.AnimalCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.AnimalDisplayDto;

import java.util.List;

public interface AnimalService {
    List<AnimalDisplayDto> getAllAnimals();

    // Nyilvános lekérdezés
    List<AnimalCrudDto> getAllPublicAnimals();
}
