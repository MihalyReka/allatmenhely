package allatmenhelyNyilvantartas.allatMenhely.service.dto.crud;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.EgeszsegAllapot;
import allatmenhelyNyilvantartas.allatMenhely.data.enums.FogadasiAllapot;
import allatmenhelyNyilvantartas.allatMenhely.data.enums.Neme;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BefogadoCrudDto {

    //@NotBlank
    // private Long id;


    private String nev;


    private Neme neme;

    private LocalDate szDatum;

    @Pattern(regexp = "^\\+?[0-9]{9}$")
    private String telefonSzam;

    @Email
    private String email;
}
