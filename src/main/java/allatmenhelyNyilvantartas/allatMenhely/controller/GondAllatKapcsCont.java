package allatmenhelyNyilvantartas.allatMenhely.controller;

import allatmenhelyNyilvantartas.allatMenhely.service.GondAllatKapcsService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.GondAllatKapcsCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.GondAllatKapcsDisplayDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gond-allat-kapcs")
@RequiredArgsConstructor
public class GondAllatKapcsCont {
    private final GondAllatKapcsService gondAllatKapcsService;

    @GetMapping
    public List<GondAllatKapcsDisplayDto> getAllGondAllatKapcs() {
        return gondAllatKapcsService.getAllGondAllatKapcs();
    }

    @GetMapping("/{id}")
    public GondAllatKapcsDisplayDto getGondAllatKapcsById(
            @PathVariable Long id) {
        return gondAllatKapcsService.getGondAllatKapcsolatId(id);
    }

    @PostMapping
    public GondAllatKapcsDisplayDto createGondAllatKapcs(
            @Valid @RequestBody GondAllatKapcsCrudDto dto) {
        return gondAllatKapcsService.createGondAllatKapcs(dto);
    }

    @PutMapping("/{id}")
    public GondAllatKapcsDisplayDto updateGondAllatKapcs(
            @PathVariable Long id,
            @Valid @RequestBody GondAllatKapcsCrudDto dto) {
        return gondAllatKapcsService.updateGondAllatKapcs(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteGondAllatKapcs(@PathVariable Long id) {
        gondAllatKapcsService.deleteGondAllatKapcs(id);
    }
}
