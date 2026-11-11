package allatmenhelyNyilvantartas.allatMenhely.service.impl;


import allatmenhelyNyilvantartas.allatMenhely.data.entity.AnimalEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.entity.DolgozoEnti;
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
        return gondAllatMapper.entityListToDtoList(
                gondAllatRepo.findAll()
        );
    }

    @Override
    public GondAllatKapcsDisplayDto getGondAllatKapcsolatId(Long id) {
        GondAllatKapcsEnti kapcsolat = gondAllatRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("A gondozói kapcsolat nem található!")
                );

        return gondAllatMapper.entityToDto(kapcsolat);

    }

    @Override
    public GondAllatKapcsDisplayDto createGondAllatKapcs(
            GondAllatKapcsCrudDto dto) {

        if (dto.getEddig() != null &&
                dto.getEddig().isBefore(dto.getKezdet())) {
            throw new RuntimeException(
                    "A befejezés dátuma nem lehet korábbi a kezdés dátumánál."
            );
        }

        if (dto.getEddig() == null &&
                gondAllatRepo.existsByAnimal_IdAndEddigIsNull(
                        dto.getAnimalId())) {
            throw new RuntimeException(
                    "Az állathoz már tartozik aktív gondozási kapcsolat."
            );
        }

        DolgozoEnti dolgozo = dolgozoRepo.findById(dto.getGondozoId())
                .orElseThrow(() -> new RuntimeException(
                        "A dolgozó nem található: " + dto.getGondozoId()
                ));

        AnimalEnti animal = animalRepo.findById(dto.getAnimalId())
                .orElseThrow(() -> new RuntimeException(
                        "Az állat nem található: " + dto.getAnimalId()
                ));

        GondAllatKapcsEnti kapcsolat = new GondAllatKapcsEnti();
        kapcsolat.setDolgozo(dolgozo);
        kapcsolat.setAnimal(animal);
        kapcsolat.setKezdet(dto.getKezdet());
        kapcsolat.setEddig(dto.getEddig());

        return gondAllatMapper.entityToDto(
                gondAllatRepo.save(kapcsolat)
        );
    }


@Override
    public GondAllatKapcsDisplayDto updateGondAllatKapcs(Long id, GondAllatKapcsCrudDto dto) {
    GondAllatKapcsEnti kapcsolat = gondAllatRepo.findById(id)
            .orElseThrow(() -> new RuntimeException(
                    "A gondozási kapcsolat nem található: " + id
            ));

    if (dto.getEddig() != null &&
            dto.getEddig().isBefore(dto.getKezdet())) {
        throw new RuntimeException(
                "A befejezés dátuma nem lehet korábbi a kezdés dátumánál."
        );
    }

    if (dto.getEddig() == null &&
            gondAllatRepo
                    .existsByAnimal_IdAndEddigIsNullAndIdNot(
                            dto.getAnimalId(), id)) {
        throw new RuntimeException(
                "Az állathoz már tartozik másik aktív gondozási kapcsolat."
        );
    }

    DolgozoEnti dolgozo = dolgozoRepo.findById(dto.getGondozoId())
            .orElseThrow(() -> new RuntimeException(
                    "A dolgozó nem található: " + dto.getGondozoId()
            ));

    AnimalEnti animal = animalRepo.findById(dto.getAnimalId())
            .orElseThrow(() -> new RuntimeException(
                    "Az állat nem található: " + dto.getAnimalId()
            ));

    kapcsolat.setDolgozo(dolgozo);
    kapcsolat.setAnimal(animal);
    kapcsolat.setKezdet(dto.getKezdet());
    kapcsolat.setEddig(dto.getEddig());

    return gondAllatMapper.entityToDto(
            gondAllatRepo.save(kapcsolat)
    );
    }

    @Override
    public void deleteGondAllatKapcs(Long id) {
        if (!gondAllatRepo.existsById(id)) {
            throw new RuntimeException(
                    "A gondozási kapcsolat nem található: " + id
            );
        }

        gondAllatRepo.deleteById(id);

    }
}
