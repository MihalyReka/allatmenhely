package allatmenhelyNyilvantartas.allatMenhely.controller;

import allatmenhelyNyilvantartas.allatMenhely.service.BefogadoService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.BefogadoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.BefogadoTeljesLekeresDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.BefogadoDisplayDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/befogado")
@RequiredArgsConstructor
public class BefogadoCont {
    private final BefogadoService befogadoService;

    @GetMapping
    public List<BefogadoTeljesLekeresDto> getAllBefogadok() {
        return befogadoService.getAllBefogadok();
    }

    @GetMapping("/public")
    public List<BefogadoDisplayDto> getAllPublicBefogadok() {
        return befogadoService.getAllPublicBefogadok();
    }

    @GetMapping("/{id}")
    public BefogadoTeljesLekeresDto getBefogadoById(@PathVariable Long id) {
        return befogadoService.getBefogadoById(id);
    }

    @GetMapping("/public/{id}")
    public BefogadoDisplayDto getPublicBefogadoById(@PathVariable Long id) {
        return befogadoService.getPublicBefogadoById(id);
    }

    @PostMapping
    public BefogadoTeljesLekeresDto createBefogado(
            @Valid @RequestBody BefogadoCrudDto befogadoCrudDto) {
        return befogadoService.createBefogado(befogadoCrudDto);
    }

    @PutMapping("/{id}")
    public BefogadoTeljesLekeresDto updateBefogado(
            @PathVariable Long id,
            @Valid @RequestBody BefogadoCrudDto befogadoCrudDto) {
        return befogadoService.updateBefogado(id, befogadoCrudDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBefogado(@PathVariable Long id) {
        befogadoService.deleteBefogado(id);
    }

}
