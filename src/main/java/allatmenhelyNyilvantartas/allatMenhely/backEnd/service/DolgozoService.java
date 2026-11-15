package allatmenhelyNyilvantartas.allatMenhely.backEnd.service;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.DolgozoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.display.DolgozoDisplayDto;

import java.util.List;

public interface DolgozoService {

    List<DolgozoDisplayDto> getAllDolgozo();
    DolgozoDisplayDto getDolgozoById(Long id);
    DolgozoCrudDto getSajatDolgozo(String username);
    DolgozoDisplayDto createDolgozo(DolgozoCrudDto dolgozoDto);
    DolgozoDisplayDto updateDolgozo(Long id,DolgozoCrudDto dolgozoCrudDto);
    void deleteDolgozo(Long id);
}
