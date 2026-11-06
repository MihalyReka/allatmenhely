package allatmenhelyNyilvantartas.allatMenhely.controller;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.AnimalEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.entity.HelyszinEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.AnimalService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.AnimalCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.AnimalDisplayDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor

public class AnimalCont {

    private final AnimalService animalService;

    @GetMapping
    public List<AnimalCrudDto> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    @GetMapping("/public")
    public List<AnimalDisplayDto> getAllPublicAnimals() {
        return animalService.getAllPublicAnimals();
    }

    @PostMapping
    public AnimalCrudDto createAnimal(@RequestBody AnimalCrudDto animalCrudDto) {
        return animalService.createAnimal(animalCrudDto);
    }
}
