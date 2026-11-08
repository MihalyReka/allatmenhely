package allatmenhelyNyilvantartas.allatMenhely.data.repository;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.BefogadoEnti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BefogadoRepo extends JpaRepository<BefogadoEnti,Long> {
}
