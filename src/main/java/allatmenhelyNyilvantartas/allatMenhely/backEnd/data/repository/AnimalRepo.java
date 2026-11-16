package allatmenhelyNyilvantartas.allatMenhely.backEnd.data.repository;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.AnimalEnti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepo extends JpaRepository<AnimalEnti,Long> {

    List<AnimalEnti> findByAdopter_Id(Long adopterId);
}
