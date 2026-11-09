package allatmenhelyNyilvantartas.allatMenhely.service.impl;


import allatmenhelyNyilvantartas.allatMenhely.data.entity.DolgozoEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.entity.GondozoEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.DolgozoRepo;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.GondozoRepo;
import allatmenhelyNyilvantartas.allatMenhely.service.GondozoService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.GondozoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.GondozoDisplayDto;
import allatmenhelyNyilvantartas.allatMenhely.service.mapper.GondozoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GondozoSerImpl implements GondozoService {

    private final GondozoRepo gondozoRepo;
    private final DolgozoRepo dolgozoRepo;
    private final GondozoMapper gondozoMapper;

    @Override
    public List<GondozoDisplayDto> getAllGondozo() {
        return gondozoMapper.entityListToDtoList(gondozoRepo.findAll());
    }

    @Override
    public GondozoDisplayDto getGondozoById(Long id) {
        GondozoEnti gondozo = gondozoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott gondozó nem található!"));

        return gondozoMapper.entityToDto(gondozo);
    }

    @Override
    public GondozoDisplayDto createGondozo(GondozoCrudDto gondozoCrudDto) {

        DolgozoEnti dolgozo = dolgozoRepo.findById(gondozoCrudDto.getDolgozoId())
                .orElseThrow(() -> new RuntimeException("A megadott dolgozó nem található!"));

        GondozoEnti gondozo = new GondozoEnti();
        gondozo.setDolgozo(dolgozo);

        GondozoEnti savedGondozo = gondozoRepo.save(gondozo);

        return gondozoMapper.entityToDto(savedGondozo);
    }

    @Override
    public GondozoDisplayDto updateGondozo(Long id, GondozoCrudDto gondozoCrudDto) {

        GondozoEnti gondozo = gondozoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott gondozó nem található!"));

        DolgozoEnti dolgozo = dolgozoRepo.findById(gondozoCrudDto.getDolgozoId())
                .orElseThrow(() -> new RuntimeException("A megadott dolgozó nem található!"));

        gondozo.setDolgozo(dolgozo);

        GondozoEnti updatedGondozo = gondozoRepo.save(gondozo);

        return gondozoMapper.entityToDto(updatedGondozo);
    }

    @Override
    public void deleteGondozo(Long id) {
        GondozoEnti gondozo = gondozoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott gondozó nem található!"));

        gondozoRepo.delete(gondozo);
    }
}
