package allatmenhelyNyilvantartas.allatMenhely.service.dto.display;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GondAllatKapcsDisplayDto {
    private  Long id;


    private Long dolgozoId;


    private Long animalId;


    private LocalDate kezdet;


    private LocalDate eddig;
}
