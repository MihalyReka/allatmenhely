package allatmenhelyNyilvantartas.allatMenhely.service.impl;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.AnimalEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.AnimalRepo;
import allatmenhelyNyilvantartas.allatMenhely.service.AnimalService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.AnimalCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.AnimalDisplayDto;
import allatmenhelyNyilvantartas.allatMenhely.service.mapper.AnimalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalSerImpl implements AnimalService {

    private final AnimalRepo animalRepo;
    private final AnimalMapper animalMapper;


    @Override
    public List<AnimalDisplayDto> getAllAnimals() {
        //return List.of();
        return animalMapper.entityListToPublicDtoList(
                animalRepo.findAll()
        );
    }

    @Override
    public List<AnimalCrudDto> getAllPublicAnimals() {
       // return List.of();
        return animalMapper.entityListToDtoList(
                animalRepo.findAll()
        );
    }
}
