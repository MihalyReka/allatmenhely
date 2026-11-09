package allatmenhelyNyilvantartas.allatMenhely.service;

import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.GondozoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.GondozoDisplayDto;

import java.util.List;

public interface GondozoService {
    List<GondozoDisplayDto> getAllGondozo();

    GondozoDisplayDto getGondozoById(Long id);

    GondozoDisplayDto createGondozo(GondozoCrudDto gondozoCrudDto);

    GondozoDisplayDto updateGondozo(Long id, GondozoCrudDto gondozoCrudDto);

    void deleteGondozo(Long id);
}
