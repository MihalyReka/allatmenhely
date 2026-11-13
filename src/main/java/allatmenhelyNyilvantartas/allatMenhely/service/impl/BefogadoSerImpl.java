package allatmenhelyNyilvantartas.allatMenhely.service.impl;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.BefogadoEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.entity.FelhasznaloEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.BefogadoRepo;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.FelhasznaloRepo;
import allatmenhelyNyilvantartas.allatMenhely.service.BefogadoService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.BefogadoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.BefogadoTeljesLekeresDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.BefogadoDisplayDto;
import allatmenhelyNyilvantartas.allatMenhely.service.mapper.BefogadoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BefogadoSerImpl implements BefogadoService {


    private final BefogadoRepo befogadoRepo;
    private final BefogadoMapper befogadoMapper;
    private  final FelhasznaloRepo felhasznaloRepo;


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
    public void deleteBefogado(Long id) {
        BefogadoEnti befogado = befogadoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("A megadott befogadó nem található!"));

        befogadoRepo.delete(befogado);
    }
}
