package allatmenhelyNyilvantartas.allatMenhely.data.repository;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GondAllatKapcsRepo extends JpaRepository<GondAllatKapcsEnti,Long> {

    boolean existsByAnimal_IdAndEddigIsNull(Long animalId);
    boolean existsByAnimal_IdAndEddigIsNullAndIdNot(Long animalId, Long id);
}
