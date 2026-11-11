package allatmenhelyNyilvantartas.allatMenhely.service.dto.crud;


import lombok.Data;

import java.time.LocalDate;

@Data
public class GondAllatKapcsCrudDto {

    //private  Long id;


    private Long dolgozoId;


    private Long animalId;


    private LocalDate kezdet;


    private LocalDate eddig;
}
