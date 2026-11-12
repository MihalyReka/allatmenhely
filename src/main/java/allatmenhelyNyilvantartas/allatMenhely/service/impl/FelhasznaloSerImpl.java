package allatmenhelyNyilvantartas.allatMenhely.service.impl;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.BefogadoEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.entity.DolgozoEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.entity.FelhasznaloEnti;
import allatmenhelyNyilvantartas.allatMenhely.data.enums.Role;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.BefogadoRepo;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.DolgozoRepo;
import allatmenhelyNyilvantartas.allatMenhely.data.repository.FelhasznaloRepo;
import allatmenhelyNyilvantartas.allatMenhely.service.FelhasznaloService;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.FelhasznaloAdminCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.FelhasznaloCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.crud.FelhasznaloElsoCrudDto;
import allatmenhelyNyilvantartas.allatMenhely.service.dto.display.FelhasznaloDisplayDto;
import allatmenhelyNyilvantartas.allatMenhely.service.mapper.FelhasznaloMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FelhasznaloSerImpl implements FelhasznaloService {
    private final FelhasznaloRepo felhasznaloRepo;
    private final DolgozoRepo dolgozoRepo;
    private final BefogadoRepo befogadoRepo;
    private final FelhasznaloMapper felhasznaloMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<FelhasznaloDisplayDto> getAllFelhasznalo() {
        return felhasznaloRepo.findAll()
                .stream()
                .map(felhasznaloMapper::entityToDto)
                .toList();
    }

    @Override
    public FelhasznaloDisplayDto getFelhasznaloById(Long id) {
        FelhasznaloEnti felhasznalo = felhasznaloRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "A felhasználó nem található: " + id));

        return felhasznaloMapper.entityToDto(felhasznalo);
    }

    @Override
    public FelhasznaloCrudDto getFelhasznaloUsernameById(Long id) {
        FelhasznaloEnti felhasznalo = felhasznaloRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Felhasználó nem található: " + id));

        FelhasznaloCrudDto dto = new FelhasznaloCrudDto();
        dto.setUsername(felhasznalo.getUsername());

        return dto;
    }

    @Override
    @Transactional
    public FelhasznaloDisplayDto createFelhasznalo(
            FelhasznaloElsoCrudDto dto) {

        if (felhasznaloRepo.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Ez a felhasználónév már foglalt!");
        }

        FelhasznaloEnti felhasznalo = new FelhasznaloEnti();

        felhasznalo.setUsername(dto.getUsername());
        felhasznalo.setPassword(passwordEncoder.encode(dto.getPassword()));
        felhasznalo.setRole(Role.BEFOGADO);

        BefogadoEnti befogado = new BefogadoEnti();
        befogado.setNev(dto.getNev());
        befogado.setNeme(dto.getNeme());
        befogado.setSzDatum(dto.getSzDatum());
        befogado.setTelefonSzam(dto.getTelefonSzam());
        befogado.setEmail(dto.getEmail());

        befogado = befogadoRepo.save(befogado);

        felhasznalo.setBefogado(befogado);

        return felhasznaloMapper.entityToDto(
                felhasznaloRepo.save(felhasznalo));
    }

    @Override
    public FelhasznaloDisplayDto updateFelhasznalo(
            Long id, FelhasznaloCrudDto dto) {

        FelhasznaloEnti felhasznalo = felhasznaloRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "A felhasználó nem található: " + id));

        if (!felhasznalo.getUsername().equals(dto.getUsername())
                && felhasznaloRepo.existsByUsername(dto.getUsername())) {
            throw new RuntimeException("Ez a felhasználónév már foglalt!");
        }

        felhasznalo.setUsername(dto.getUsername());

        return felhasznaloMapper.entityToDto(
                felhasznaloRepo.save(felhasznalo));
    }

    @Override
    @Transactional
    public FelhasznaloDisplayDto updateFelhasznaloAdmin(
            Long id, FelhasznaloAdminCrudDto dto) {

        FelhasznaloEnti felhasznalo = felhasznaloRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "A felhasználó nem található: " + id));

        if (dto.getUsername() != null &&
                !dto.getUsername().isBlank()) {

            if (!felhasznalo.getUsername().equals(dto.getUsername())
                    && felhasznaloRepo.existsByUsername(dto.getUsername())) {
                throw new RuntimeException("Ez a felhasználónév már foglalt!");
            }

            felhasznalo.setUsername(dto.getUsername());
        }

        if (dto.getPassword() != null &&
                !dto.getPassword().isBlank()) {
            felhasznalo.setPassword(
                    passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getRole() == null) {
            throw new RuntimeException("A szerepkör megadása kötelező!");
        }

        // Dolgozói kapcsolat beállítása
        if (dto.getDolgozoId() != null) {

            DolgozoEnti dolgozo = dolgozoRepo.findById(dto.getDolgozoId())
                    .orElseThrow(() -> new RuntimeException(
                            "A dolgozó nem található!"));

            if (felhasznaloRepo.existsByDolgozo_IdAndIdNot(
                    dto.getDolgozoId(), id)) {
                throw new RuntimeException(
                        "Ehhez a dolgozóhoz már tartozik másik felhasználói fiók!");
            }

            felhasznalo.setDolgozo(dolgozo);
        }

        if (dto.getBefogadoId() != null) {

            BefogadoEnti befogado = befogadoRepo.findById(dto.getBefogadoId())
                    .orElseThrow(() -> new RuntimeException(
                            "A befogadó nem található!"));

            if (felhasznaloRepo.existsByBefogado_IdAndIdNot(
                    dto.getBefogadoId(), id)) {
                throw new RuntimeException(
                        "Ehhez a befogadóhoz már tartozik másik felhasználói fiók!");
            }

            felhasznalo.setBefogado(befogado);
        }

        if (dto.getRole() == Role.DOLGOZO ||
                dto.getRole() == Role.ADMIN) {

            if (felhasznalo.getDolgozo() == null) {
                throw new RuntimeException(
                        "Ehhez a szerepkörhöz dolgozói rekord szükséges!");
            }

        } else if (dto.getRole() == Role.BEFOGADO) {

            if (felhasznalo.getBefogado() == null) {
                throw new RuntimeException(
                        "A befogadó szerepkörhöz befogadói rekord szükséges!");
            }
        }

        felhasznalo.setRole(dto.getRole());

        return felhasznaloMapper.entityToDto(
                felhasznaloRepo.save(felhasznalo));
    }

    @Override
    public void deleteFelhasznalo(Long id) {
        FelhasznaloEnti felhasznalo = felhasznaloRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "A felhasználó nem található: " + id));

        felhasznaloRepo.delete(felhasznalo);
    }
}