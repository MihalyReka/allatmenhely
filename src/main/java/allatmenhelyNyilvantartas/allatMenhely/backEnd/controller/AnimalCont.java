package allatmenhelyNyilvantartas.allatMenhely.backEnd.controller;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.AnimalService;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.AnimalCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.AnimalTeljesLekeresDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.*;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.display.AnimalDisplayDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor

public class AnimalCont {

    private final AnimalService animalService;

    @GetMapping
    public List<AnimalTeljesLekeresDto> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    @GetMapping("/public")
    public List<AnimalDisplayDto> getAllPublicAnimals() {
        return animalService.getAllPublicAnimals();
    }

    @GetMapping("/{id}")
    public AnimalTeljesLekeresDto getAnimalById(@PathVariable Long id) {
        return animalService.getAnimalById(id);
    }

    @GetMapping("/public/{id}")
    public AnimalDisplayDto getPublicAnimalById(@PathVariable Long id) {
        return animalService.getPublicAnimalById(id);
    }

    @PostMapping
    public AnimalTeljesLekeresDto createAnimal(@Valid @RequestBody AnimalCrudDto animalCrudDto) {
        return animalService.createAnimal(animalCrudDto);
    }

    @PutMapping("/{id}")
    public AnimalTeljesLekeresDto updateAnimal(
              @PathVariable Long id,
              @Valid @RequestBody AnimalCrudDto animalCrudDto) {

        return animalService.updateAnimal(id, animalCrudDto);
    }
    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
    }

}
