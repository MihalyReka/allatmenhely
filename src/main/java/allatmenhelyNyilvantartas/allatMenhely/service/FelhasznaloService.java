package allatmenhelyNyilvantartas.allatMenhely.service;

import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.FelhasznaloAdminCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.FelhasznaloCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.FelhasznaloElsoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.FelhasznaloDisplayDto;

import java.util.List;

public interface FelhasznaloService {
    List<FelhasznaloDisplayDto> getAllFelhasznalo();

    FelhasznaloDisplayDto getFelhasznaloById(Long id);
    FelhasznaloCrudDto getFelhasznaloUsernameById(Long id);

    FelhasznaloDisplayDto createFelhasznalo(FelhasznaloElsoCrudDto dto);

    FelhasznaloDisplayDto updateFelhasznalo(Long id, FelhasznaloCrudDto dto);
    FelhasznaloDisplayDto updateFelhasznaloAdmin(
            Long id, FelhasznaloAdminCrudDto dto);


    void deleteFelhasznalo(Long id);

}
