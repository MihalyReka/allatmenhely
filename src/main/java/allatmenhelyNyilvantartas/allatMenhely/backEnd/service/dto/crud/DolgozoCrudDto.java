package allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.enums.Neme;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DolgozoCrudDto {

    //private  Long id;

    private   String nev;

    private Neme neme;

    private LocalDate szDatum;

    @Pattern(regexp = "^\\+?[0-9]{9,12}$")
    private String telefonSzam;

    @Email
    private String email;


    private   String beosztas;
}
