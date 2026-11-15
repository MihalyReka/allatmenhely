package allatmenhelyNyilvantartas.allatMenhely.backEnd.data.repository;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.DolgozoEnti;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DolgozoRepo extends JpaRepository<DolgozoEnti,Long> {
}
