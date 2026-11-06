package allatmenhelyNyilvantartas.allatMenhely.service.dto.display;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.EgeszsegAllapot;
import allatmenhelyNyilvantartas.allatMenhely.data.enums.FogadasiAllapot;
import allatmenhelyNyilvantartas.allatMenhely.data.enums.Neme;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnimalDisplayDto {

    private String nev;

    private String fajta;

    private String allatTipus;

    private Neme neme;

    private LocalDate szDatum;

    //private LocalDate arrivalDate;

    //private FogadasiAllapot fogadasiAllapot;

    //private EgeszsegAllapot egeszsegAllapot;


}
