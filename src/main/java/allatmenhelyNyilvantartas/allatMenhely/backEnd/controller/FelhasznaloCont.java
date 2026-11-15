package allatmenhelyNyilvantartas.allatMenhely.backEnd.controller;


import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.FelhasznaloService;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.FelhasznaloAdminCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.FelhasznaloCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.FelhasznaloElsoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.display.FelhasznaloDisplayDto;
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
            @Valid @RequestBody FelhasznaloAdminCrudDto dto) {
        return felhasznaloService.updateFelhasznaloAdmin(id, dto);
    }


    @DeleteMapping("/{id}")
    public void deleteFelhasznalo(@PathVariable Long id) {
        felhasznaloService.deleteFelhasznalo(id);
    }


}
