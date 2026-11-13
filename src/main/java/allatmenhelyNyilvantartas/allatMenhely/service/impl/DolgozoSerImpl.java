package allatmenhelyNyilvantartas.allatMenhely.service.impl;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.DolgozoEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.entity.FelhasznaloEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.DolgozoRepo;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.FelhasznaloRepo;
import allatmenhelyNyilvantartas.allatMenhely.service.DolgozoService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.DolgozoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.DolgozoDisplayDto;
import allatmenhelyNyilvantartas.allatMenhely.service.mapper.DolgozoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Service
@RequiredArgsConstructor

public class DolgozoSerImpl implements DolgozoService {

    private final DolgozoRepo dolgozoRepo;
    private final DolgozoMapper dolgozoMapper;
    private final FelhasznaloRepo felhasznaloRepo;


    public List<DolgozoDisplayDto> getAllDolgozo() {
        return dolgozoMapper.entityListToDtoList(dolgozoRepo.findAll());
    }

    @Override
    public DolgozoDisplayDto getDolgozoById(Long id) {
        DolgozoEnti dolgozo = dolgozoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott dolgozó nem található!"));

        return dolgozoMapper.entityToDto(dolgozo);
    }

    @Override
    public DolgozoCrudDto getSajatDolgozo(String username) {
        FelhasznaloEnti felhasznalo = felhasznaloRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(
                        "A bejelentkezett felhasználó nem található!"
                ));

        DolgozoEnti dolgozo = felhasznalo.getDolgozo();

        if (dolgozo == null) {
            throw new RuntimeException(
                    "A felhasználóhoz nem tartozik dolgozói profil!"
            );
        }

        return dolgozoMapper.entityToDisplayDto(dolgozo);
    }

    @Override
    public DolgozoDisplayDto createDolgozo(DolgozoCrudDto dolgozoCrudDto) {
        DolgozoEnti dolgozo = dolgozoMapper.dtoToEntity(dolgozoCrudDto);

        DolgozoEnti savedDolgozo = dolgozoRepo.save(dolgozo);

        return dolgozoMapper.entityToDto(savedDolgozo);
    }

    @Override
    public DolgozoDisplayDto updateDolgozo(Long id, DolgozoCrudDto dolgozoCrudDto) {
        DolgozoEnti dolgozo = dolgozoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott dolgozó nem található!"));

        dolgozoMapper.updateEntityFromDto(dolgozoCrudDto, dolgozo);

        DolgozoEnti updatedDolgozo = dolgozoRepo.save(dolgozo);

        return dolgozoMapper.entityToDto(updatedDolgozo);
    }

    @Override
    public void deleteDolgozo(Long id) {
        DolgozoEnti dolgozo = dolgozoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott dolgozó nem található!"));

        dolgozoRepo.delete(dolgozo);
    }
}


