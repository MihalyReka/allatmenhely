package allatmenhelyNyilvantartas.allatMenhely.data.repository;

import allatmenhelyNyilvantartas.allatMenhely.data.entity.AnimalEnti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository<AnimalEnti,Long> {

    
}
