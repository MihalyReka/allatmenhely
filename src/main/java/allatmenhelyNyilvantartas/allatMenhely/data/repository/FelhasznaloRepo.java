package allatmenhelyNyilvantartas.allatMenhely.data.repository;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.FelhasznaloEnti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FelhasznaloRepo extends JpaRepository<FelhasznaloEnti,Long> {

    Optional<FelhasznaloEnti> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByDolgozo_Id(Long dolgozoId);
    boolean existsByBefogado_Id(Long befogadoId);
    //bejelenkezéshez
    boolean existsByDolgozo_IdAndIdNot(Long dolgozoId, Long id);

    boolean existsByBefogado_IdAndIdNot(Long befogadoId, Long id);


}
