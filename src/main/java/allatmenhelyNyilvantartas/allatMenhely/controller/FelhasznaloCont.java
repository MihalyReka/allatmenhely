package allatmenhelyNyilvantartas.allatMenhely.controller;


import allatmenhelyNyilvantartas.allatMenhely.service.FelhasznaloService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.FelhasznaloAdminCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.FelhasznaloCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.FelhasznaloElsoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.FelhasznaloDisplayDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/felhasznalok")
@RequiredArgsConstructor
public class FelhasznaloCont {

    private final FelhasznaloService felhasznaloService;

    // Összes felhasználó lekérése
    @GetMapping
    public List<FelhasznaloDisplayDto> getAllFelhasznalo() {
        return felhasznaloService.getAllFelhasznalo();
    }

    // Egy felhasználó lekérése
    @GetMapping("/{id}")
    public FelhasznaloDisplayDto getFelhasznaloById(@PathVariable Long id) {
        return felhasznaloService.getFelhasznaloById(id);
    }

    // Regisztráció
    @PostMapping("/regisztracio")
    public FelhasznaloDisplayDto createFelhasznalo(
            @Valid @RequestBody FelhasznaloElsoCrudDto dto) {
        return felhasznaloService.createFelhasznalo(dto);
    }

    // Saját felhasználónév módosítása
    @PutMapping("/{id}")
    public FelhasznaloDisplayDto updateFelhasznalo(
            @PathVariable Long id,
            @Valid @RequestBody FelhasznaloCrudDto dto) {
        return felhasznaloService.updateFelhasznalo(id, dto);
    }

    // Adminisztrátori módosítás
    @PutMapping("/admin/{id}")
    public FelhasznaloDisplayDto updateFelhasznaloAdmin(
            @PathVariable Long id,
            @RequestBody FelhasznaloAdminCrudDto dto) {
        return felhasznaloService.updateFelhasznaloAdmin(id, dto);
    }

    // Felhasználó törlése
    @DeleteMapping("/{id}")
    public void deleteFelhasznalo(@PathVariable Long id) {
        felhasznaloService.deleteFelhasznalo(id);
    }


}
