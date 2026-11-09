package allatmenhelyNyilvantartas.allatMenhely.controller;


import allatmenhelyNyilvantartas.allatMenhely.service.GondozoService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.GondozoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.GondozoDisplayDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gondozo")
@RequiredArgsConstructor
public class GondozoCont {

    private final GondozoService gondozoService;

    @GetMapping
    public List<GondozoDisplayDto> getAllGondozo() {
        return gondozoService.getAllGondozo();
    }

    @GetMapping("/{id}")
    public GondozoDisplayDto getGondozoById(@PathVariable Long id) {
        return gondozoService.getGondozoById(id);
    }

    @PostMapping
    public GondozoDisplayDto createGondozo(
            @Valid @RequestBody GondozoCrudDto gondozoCrudDto) {
        return gondozoService.createGondozo(gondozoCrudDto);
    }

    @PutMapping("/{id}")
    public GondozoDisplayDto updateGondozo(
            @PathVariable Long id,
            @Valid @RequestBody GondozoCrudDto gondozoCrudDto) {
        return gondozoService.updateGondozo(id, gondozoCrudDto);
    }

    @DeleteMapping("/{id}")
    public void deleteGondozo(@PathVariable Long id) {
        gondozoService.deleteGondozo(id);
    }
}
