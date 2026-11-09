package allatmenhelyNyilvantartas.allatMenhely.service;

import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.BefogadoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.BefogadoTeljesLekeresDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.BefogadoDisplayDto;

import java.util.List;

public interface BefogadoService {

    List<BefogadoTeljesLekeresDto> getAllBefogadok();

    List<BefogadoDisplayDto> getAllPublicBefogadok();

    BefogadoTeljesLekeresDto getBefogadoById(Long id);

    BefogadoDisplayDto getPublicBefogadoById(Long id);

    BefogadoTeljesLekeresDto createBefogado(BefogadoCrudDto befogadoCrudDto);

    BefogadoTeljesLekeresDto updateBefogado(Long id, BefogadoCrudDto befogadoCrudDto);

    void deleteBefogado(Long id);
}
