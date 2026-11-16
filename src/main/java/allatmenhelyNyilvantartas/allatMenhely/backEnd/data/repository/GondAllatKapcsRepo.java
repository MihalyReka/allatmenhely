package allatmenhelyNyilvantartas.allatMenhely.backEnd.data.repository;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.GondAllatKapcsEnti;
import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GondAllatKapcsRepo extends JpaRepository<GondAllatKapcsEnti,Long> {

    boolean existsByAnimal_IdAndEddigIsNull(Long animalId);
    boolean existsByAnimal_IdAndEddigIsNullAndIdNot(Long animalId, Long id);
    void deleteByDolgozo_Id(Long dolgozoId);

}
