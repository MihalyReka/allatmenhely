package allatmenhelyNyilvantartas.allatMenhely.service.impl;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.AnimalEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.entity.BefogadoEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.entity.HelyszinEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.AnimalRepo;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.HelyszinRepo;
import allatmenhelyNyilvantartas.allatMenhely.service.AnimalService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.AnimalCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.AnimalDisplayDto;
import allatmenhelyNyilvantartas.allatMenhely.service.mapper.AnimalMapper;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.BefogadoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalSerImpl implements AnimalService {

    private final AnimalRepo animalRepo;
    private final AnimalMapper animalMapper;
    private final BefogadoRepo befogadoRepo;
    private final HelyszinRepo helyszinRepo;


    @Override
    public List<AnimalDisplayDto> getAllPublicAnimals() {
        //return List.of();
        return animalMapper.entityListToPublicDtoList(
                animalRepo.findAll()
        );
    }

    @Override
    public List<AnimalCrudDto> getAllAnimals()  {
       // return List.of();
        return animalMapper.entityListToDtoList(
                animalRepo.findAll()
        );
    }
    @Override
    public AnimalCrudDto createAnimal(AnimalCrudDto animalCrudDto) {
        AnimalEnti animal = animalMapper.dtoToEntity(animalCrudDto);

        // Helyszín hozzárendelése
        if (animalCrudDto.getHelyszinId() != null) {
            HelyszinEnti helyszin = helyszinRepo
                    .findById(animalCrudDto.getHelyszinId())
                    .orElseThrow(() ->
                            new RuntimeException("A helyszín nem található!")
                    );

            animal.setHelyszin(helyszin);
        }

        // Örökbefogadó hozzárendelése
        if (animalCrudDto.getAdopterId() != null) {
            BefogadoEnti befogado = befogadoRepo
                    .findById(animalCrudDto.getAdopterId())
                    .orElseThrow(() ->
                            new RuntimeException("Az örökbefogadó nem található!")
                    );

            animal.setAdopter(befogado);
        }

        // Mentés adatbázisba
        AnimalEnti savedAnimal = animalRepo.save(animal);

        // Mentett adat visszaalakítása DTO-vá
        return animalMapper.entityToDto(savedAnimal);
    }
}
