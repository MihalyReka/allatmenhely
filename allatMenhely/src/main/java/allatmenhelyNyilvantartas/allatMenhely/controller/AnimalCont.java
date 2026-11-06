package allatmenhelyNyilvantartas.allatMenhely.controller;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.AnimalEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.entity.HelyszinEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor

public class AnimalCont {

    private final AnimalService animalService;

    @GetMapping
    public List<AnimalEnti> getAllAnimals(){
        return animalService.getAllAnimals();
    }
}
