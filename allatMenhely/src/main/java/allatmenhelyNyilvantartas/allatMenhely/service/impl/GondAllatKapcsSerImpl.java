package allatmenhelyNyilvantartas.allatMenhely.service.impl;


import allatmenhelyNyilvantartas.allatMenhely.data.entity.GondAllatKapcsEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.AnimalRepo;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.DolgozoRepo;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.GondAllatKapcsRepo;
import allatmenhelyNyilvantartas.allatMenhely.service.GondAllatKapcsService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.GondAllatKapcsCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.GondAllatKapcsDisplayDto;
import allatmenhelyNyilvantartas.allatMenhely.service.mapper.GondAllatKapcsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GondAllatKapcsSerImpl implements GondAllatKapcsService {

    private final GondAllatKapcsRepo gondAllatRepo;
    private final DolgozoRepo dolgozoRepo;
    private final AnimalRepo animalRepo;
    private final GondAllatKapcsMapper gondAllatMapper;

    @Override
    public List<GondAllatKapcsDisplayDto> getAllGondAllatKapcs() {
        return gondAllatMapper.entityListToDtoList(gondAllatRepo.findAll());
    }

    @Override
    public GondAllatKapcsDisplayDto getGondAllatKapcsolatId(Long id) {
        //GondAllatKapcsEnti kapcsolat=gondAllatRepo.findAllById(id).orElseThrow
        //return gondAllatMapper.entityToDto(kapcsolat);
        return null;
    }

    @Override
    public GondAllatKapcsDisplayDto createGondAllatKapcs(GondAllatKapcsCrudDto dto) {
        return null;
    }

    @Override
    public GondAllatKapcsDisplayDto updateGondAllatKapcs(Long id, GondAllatKapcsCrudDto dto) {
        return null;
    }

    @Override
    public void deleteGondAllatKapcs(Long id) {

    }
}
