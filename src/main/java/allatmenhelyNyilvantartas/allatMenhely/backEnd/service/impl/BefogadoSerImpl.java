package allatmenhelyNyilvantartas.allatMenhely.backEnd.service.impl;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.AnimalEnti;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.BefogadoEnti;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.FelhasznaloEnti;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.repository.AnimalRepo;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.repository.BefogadoRepo;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.repository.FelhasznaloRepo;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.BefogadoService;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.BefogadoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud.BefogadoTeljesLekeresDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.display.BefogadoDisplayDto;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.service.mapper.BefogadoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BefogadoSerImpl implements BefogadoService {


    private final BefogadoRepo befogadoRepo;
    private final BefogadoMapper befogadoMapper;
    private  final FelhasznaloRepo felhasznaloRepo;
    private  final AnimalRepo animalRepo;


    @Override
    public List<BefogadoTeljesLekeresDto> getAllBefogadok() {
        return befogadoMapper.entityListToDtoList(befogadoRepo.findAll());
    }


    @Override
    public BefogadoTeljesLekeresDto getBefogadoById(Long id) {
        BefogadoEnti befogado = befogadoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott befogadó nem található!"));

        return befogadoMapper.entityToDto(befogado);
    }


    @Override
    public BefogadoTeljesLekeresDto createBefogado(BefogadoCrudDto befogadoCrudDto) {
        BefogadoEnti befogado = befogadoMapper.dtoToEntity(befogadoCrudDto);

        BefogadoEnti savedBefogado = befogadoRepo.save(befogado);

        return befogadoMapper.entityToDto(savedBefogado);
    }

    @Override
    public BefogadoTeljesLekeresDto updateBefogado(Long id, BefogadoCrudDto befogadoCrudDto) {
        BefogadoEnti befogado = befogadoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott befogadó nem található!"));

        befogadoMapper.updateEntityFromDto(befogadoCrudDto, befogado);

        BefogadoEnti updatedBefogado = befogadoRepo.save(befogado);

        return befogadoMapper.entityToDto(updatedBefogado);
    }

    @Override
    public BefogadoDisplayDto getSajatBefogado(String username) {
        FelhasznaloEnti felhasznalo = felhasznaloRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(
                        "A bejelentkezett felhasználó nem található!"
                ));

        BefogadoEnti befogado = felhasznalo.getBefogado();

        if (befogado == null) {
            throw new RuntimeException(
                    "A felhasználóhoz nem tartozik befogadói profil!"
            );
        }

        return befogadoMapper.entityToDisplayDto(befogado);
    }

    @Override
    @Transactional
    public void deleteBefogado(Long id) {

            BefogadoEnti befogado = befogadoRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException(
                            "A megadott befogadó nem található!"
                    ));

            List<AnimalEnti> allatok = animalRepo.findByAdopter_Id(id);

            for (AnimalEnti allat : allatok) {
                allat.setAdopter(null);
            }

            animalRepo.saveAll(allatok);


            felhasznaloRepo.findByBefogado_Id(id)
                    .ifPresent(felhasznaloRepo::delete);

            befogadoRepo.delete(befogado);
        }
//    public void deleteBefogado(Long id) {
//        BefogadoEnti befogado = befogadoRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("A megadott befogadó nem található!"));
//
//        befogadoRepo.delete(befogado);
//    }
}
