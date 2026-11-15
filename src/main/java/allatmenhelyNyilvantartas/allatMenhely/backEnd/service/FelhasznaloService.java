package allatmenhelyNyilvantartas.allatMenhely.backEnd.service;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.FelhasznaloAdminCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.FelhasznaloCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.FelhasznaloElsoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.display.FelhasznaloDisplayDto;

import java.util.List;

public interface FelhasznaloService {
    List<FelhasznaloDisplayDto> getAllFelhasznalo();

    FelhasznaloDisplayDto getFelhasznaloById(Long id);


    FelhasznaloDisplayDto createFelhasznalo(FelhasznaloElsoCrudDto dto);

    FelhasznaloDisplayDto updateFelhasznalo(Long id, FelhasznaloCrudDto dto);
    FelhasznaloDisplayDto updateFelhasznaloAdmin(
            Long id, FelhasznaloAdminCrudDto dto);


    void deleteFelhasznalo(Long id);

}
