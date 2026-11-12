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


    @GetMapping
    public List<FelhasznaloDisplayDto> getAllFelhasznalo() {
        return felhasznaloService.getAllFelhasznalo();
    }


    @GetMapping("/{id}")
    public FelhasznaloDisplayDto getFelhasznaloById(@PathVariable Long id) {
        return felhasznaloService.getFelhasznaloById(id);
    }

    @GetMapping("/{id}/username")
    public FelhasznaloCrudDto getFelhasznaloUsernameById(@PathVariable Long id) {
        return felhasznaloService.getFelhasznaloUsernameById(id);
    }


    @PostMapping("/regisztracio")
    public FelhasznaloDisplayDto createFelhasznalo(
            @Valid @RequestBody FelhasznaloElsoCrudDto dto) {
        return felhasznaloService.createFelhasznalo(dto);
    }


    @PutMapping("/{id}")
    public FelhasznaloDisplayDto updateFelhasznalo(
            @PathVariable Long id,
            @Valid @RequestBody FelhasznaloCrudDto dto) {
        return felhasznaloService.updateFelhasznalo(id, dto);
    }


    @PutMapping("/admin/{id}")
    public FelhasznaloDisplayDto updateFelhasznaloAdmin(
            @PathVariable Long id,
            @RequestBody FelhasznaloAdminCrudDto dto) {
        return felhasznaloService.updateFelhasznaloAdmin(id, dto);
    }


    @DeleteMapping("/{id}")
    public void deleteFelhasznalo(@PathVariable Long id) {
        felhasznaloService.deleteFelhasznalo(id);
    }


}
