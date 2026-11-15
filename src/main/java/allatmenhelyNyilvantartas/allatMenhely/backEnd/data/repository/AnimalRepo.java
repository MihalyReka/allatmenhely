package allatmenhelyNyilvantartas.allatMenhely.backEnd.data.repository;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.entity.AnimalEnti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository<AnimalEnti,Long> {

    
}
