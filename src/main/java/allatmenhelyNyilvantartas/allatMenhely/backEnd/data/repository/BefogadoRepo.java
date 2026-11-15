package allatmenhelyNyilvantartas.allatMenhely.backEnd.data.repository;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.BefogadoEnti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BefogadoRepo extends JpaRepository<BefogadoEnti,Long> {
}
