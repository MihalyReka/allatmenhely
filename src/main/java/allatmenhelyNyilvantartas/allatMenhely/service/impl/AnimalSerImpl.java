package allatmenhelyNyilvantartas.allatMenhely.service.impl;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.*;
import allatmenhelyNyilvantartas.allatMenhely.data.enums.EgeszsegAllapot;
import allatmenhelyNyilvantartas.allatMenhely.data.enums.FogadasiAllapot;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.*;
import allatmenhelyNyilvantartas.allatMenhely.service.AnimalService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.*;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.AnimalDisplayDto;
import allatmenhelyNyilvantartas.allatMenhely.service.mapper.AnimalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalSerImpl implements AnimalService {

    private final AnimalRepo animalRepo;
    private final AnimalMapper animalMapper;
    private final BefogadoRepo befogadoRepo;



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

        // Örökbefogadó hozzárendelése
        if (animalCrudDto.getAdopterId() != null) {
            BefogadoEnti befogado = befogadoRepo
                    .findById(animalCrudDto.getAdopterId())
                    .orElseThrow(() ->
                            new RuntimeException("Az örökbefogadó nem található!")
                    );

            animal.setAdopter(befogado);
        }
        //mikor adoptálhato
        if(animal.getEgeszsegAllapot()==EgeszsegAllapot.KRITIKUS || animal.getEgeszsegAllapot()==EgeszsegAllapot.KEZELES_ALAT){
            animal.setFogadasiAllapot(FogadasiAllapot.NEM_BEFOGADHATO);
            animal.setAdopter(null);

        }else animal.setFogadasiAllapot(FogadasiAllapot.ADOPTALHATO);

        if (animal.getAdopter() != null) {
            animal.setFogadasiAllapot(FogadasiAllapot.ADOPTALT);
        } else if (animal.getFogadasiAllapot() == FogadasiAllapot.ADOPTALT) {
        throw new RuntimeException(
                "Az adoptált állatnak kötelező befogadóval rendelkeznie!"
        );
        }


        AnimalEnti savedAnimal = animalRepo.save(animal);

        return animalMapper.entityToDto(savedAnimal);
    }

    @Override
    public AnimalTeljesLekeresDto updateAnimal(Long id, AnimalCrudDto animalCrudDto) {
        AnimalEnti animal = animalRepo.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,"A megadott állat nem található!")
                );

        animalMapper.updateEntityFromDto(animalCrudDto, animal);

        if (animalCrudDto.getAdopterId() != null) {
            BefogadoEnti befogado = befogadoRepo
                    .findById(animalCrudDto.getAdopterId())
                    .orElseThrow(() ->
                            new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,"Az örökbefogadó nem található!")
                    );

            animal.setAdopter(befogado);
        } else {
            animal.setAdopter(null);
        }
        if(animal.getEgeszsegAllapot()==EgeszsegAllapot.KRITIKUS || animal.getEgeszsegAllapot()==EgeszsegAllapot.KEZELES_ALAT){
            animal.setFogadasiAllapot(FogadasiAllapot.NEM_BEFOGADHATO);
            animal.setAdopter(null);

        }else animal.setFogadasiAllapot(FogadasiAllapot.ADOPTALHATO);
        if (animal.getAdopter() != null) {
            animal.setFogadasiAllapot(FogadasiAllapot.ADOPTALT);
        } else if (animal.getFogadasiAllapot() == FogadasiAllapot.ADOPTALT) {
        throw new RuntimeException(
                "Az adoptált állatnak kötelező befogadóval rendelkeznie!"
        );
        }

        AnimalEnti updatedAnimal = animalRepo.save(animal);

        return animalMapper.entityToDto(updatedAnimal);
    }

    @Override
    public void deleteAnimal(Long id) {
        AnimalEnti animal = animalRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"A megadott állat nem található!"));

        animalRepo.delete(animal);
    }

    @Override
    public AnimalTeljesLekeresDto getAnimalById(Long id) {
        AnimalEnti animal=animalRepo.findById(id)
                .orElseThrow(()-> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"A megadott állat nem található!"));

        return animalMapper.entityToDto(animal);
    }

    @Override
    public AnimalDisplayDto getPublicAnimalById(Long id) {
        AnimalEnti animal = animalRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,"A megadott állat nem található!"));

        return animalMapper.entityToPublicDto(animal);
    }


}
