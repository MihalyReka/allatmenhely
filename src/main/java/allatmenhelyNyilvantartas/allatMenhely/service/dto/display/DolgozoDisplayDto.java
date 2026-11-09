package allatmenhelyNyilvantartas.allatMenhely.service.dto.display;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.Neme;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DolgozoDisplayDto {

    private  Long id;

    private   String nev;

    private Neme neme;

    private LocalDate szDatum;

    @Pattern(regexp = "^\\+?[0-9]{9}$")
    private String telefonSzam;

    @Email
    private String email;


    private   String beosztas;

}
