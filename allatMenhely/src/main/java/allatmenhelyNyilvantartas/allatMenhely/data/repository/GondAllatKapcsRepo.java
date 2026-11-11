package allatmenhelyNyilvantartas.allatMenhely.data.repository;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GondAllatKapcsRepo extends JpaRepository<GondAllatKapcsEnti,Long> {

    boolean vanEGondozoja(Long animalId);
    boolean vanEGondozoja2(Long animalId, Long id);
}
