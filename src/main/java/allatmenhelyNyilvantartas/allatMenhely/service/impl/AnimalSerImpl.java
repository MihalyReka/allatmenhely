package allatmenhelyNyilvantartas.allatMenhely.service.impl;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.*;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.*;
import allatmenhelyNyilvantartas.allatMenhely.service.AnimalService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.*;
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
    private final BefogadoRepo befogadoRepo;
    private final HelyszinRepo helyszinRepo;


    @Override //Get
    public List<AnimalDisplayDto> getAllPublicAnimals() {
        //return List.of();
        return animalMapper.entityListToPublicDtoList(
                animalRepo.findAll()
        );
    }

    @Override //Get
    public List<AnimalTeljesLekeresDto> getAllAnimals()  {
       // return List.of();
        return animalMapper.entityListToDtoList(
                animalRepo.findAll()
        );
    }
    @Override //POST
    public AnimalTeljesLekeresDto createAnimal(AnimalCrudDto animalCrudDto) {
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

    @Override
    public AnimalTeljesLekeresDto updateAnimal(Long id, AnimalCrudDto animalCrudDto) {
        AnimalEnti animal = animalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott állat nem található!"));

        animalMapper.updateEntityFromDto(animalCrudDto, animal);

        if (animalCrudDto.getHelyszinId() != null) {
            HelyszinEnti helyszin = helyszinRepo.findById(animalCrudDto.getHelyszinId())
                    .orElseThrow(() -> new RuntimeException("A helyszín nem található!"));
            animal.setHelyszin(helyszin);
        } else {
            animal.setHelyszin(null);
        }

        if (animalCrudDto.getAdopterId() != null) {
            BefogadoEnti befogado = befogadoRepo.findById(animalCrudDto.getAdopterId())
                    .orElseThrow(() -> new RuntimeException("Az örökbefogadó nem található!"));
            animal.setAdopter(befogado);
        } else {
            animal.setAdopter(null);
        }

        AnimalEnti updatedAnimal = animalRepo.save(animal);

        return animalMapper.entityToDto(updatedAnimal);
    }

    @Override
    public void deleteAnimal(Long id) {
        AnimalEnti animal = animalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott állat nem található!"));

        animalRepo.delete(animal);
    }

    @Override
    public AnimalTeljesLekeresDto getAnimalById(Long id) {
        AnimalEnti animal=animalRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("A megadott állat nem található!"));

        return animalMapper.entityToDto(animal);
    }

    @Override
    public AnimalDisplayDto getPublicAnimalById(Long id) {
        AnimalEnti animal = animalRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott állat nem található!"));

        return animalMapper.entityToPublicDto(animal);
    }


}
