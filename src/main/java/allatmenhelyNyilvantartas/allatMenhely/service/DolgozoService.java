package allatmenhelyNyilvantartas.allatMenhely.service;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.DolgozoEnti;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.BefogadoTeljesLekeresDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.DolgozoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.DolgozoDisplayDto;

import java.util.List;

public interface DolgozoService {

    List<DolgozoDisplayDto> getAllDolgozo();
    DolgozoDisplayDto getDolgozoById(Long id);
    DolgozoCrudDto getSajatDolgozo(String username);
    DolgozoDisplayDto createDolgozo(DolgozoCrudDto dolgozoDto);
    DolgozoDisplayDto updateDolgozo(Long id,DolgozoCrudDto dolgozoCrudDto);
    void deleteDolgozo(Long id);
}
