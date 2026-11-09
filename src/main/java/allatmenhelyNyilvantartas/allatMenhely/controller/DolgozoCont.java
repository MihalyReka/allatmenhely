package allatmenhelyNyilvantartas.allatMenhely.controller;


import allatmenhelyNyilvantartas.allatMenhely.service.DolgozoService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.DolgozoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.DolgozoDisplayDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dolgozo")
@RequiredArgsConstructor
public class DolgozoCont {
    private final DolgozoService dolgozoService;

    // Összes dolgozó lekérdezése
    @GetMapping
    public List<DolgozoDisplayDto> getAllDolgozo() {
        return dolgozoService.getAllDolgozo();
    }

    // Egy dolgozó lekérdezése azonosító alapján
    @GetMapping("/{id}")
    public DolgozoDisplayDto getDolgozoById(@PathVariable Long id) {
        return dolgozoService.getDolgozoById(id);
    }

    // Új dolgozó létrehozása
    @PostMapping
    public DolgozoDisplayDto createDolgozo(@Valid @RequestBody DolgozoCrudDto dolgozoCrudDto) {
        return dolgozoService.createDolgozo(dolgozoCrudDto);
    }

    // Meglévő dolgozó módosítása
    @PutMapping("/{id}")
    public DolgozoDisplayDto updateDolgozo(
            @PathVariable Long id,
            @Valid @RequestBody DolgozoCrudDto dolgozoCrudDto) {
        return dolgozoService.updateDolgozo(id, dolgozoCrudDto);
    }

    // Dolgozó törlése
    @DeleteMapping("/{id}")
    public void deleteDolgozo(@PathVariable Long id) {
        dolgozoService.deleteDolgozo(id);
    }
}
