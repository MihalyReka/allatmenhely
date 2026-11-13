package allatmenhelyNyilvantartas.allatMenhely.service.dto.crud;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.Neme;
import allatmenhelyNyilvantartas.allatMenhely.data.enums.Role;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FelhasznaloElsoCrudDto {
    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 7, max = 30,message = "A jelszónak legalább 8 karakter hosszúnak kell lennie!")
    private String password;

    @NotBlank
    private String nev;

    @NotNull
    private Neme neme;

    @NotNull
    private LocalDate szDatum;

    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]{8,15}$")
    private String telefonSzam;

    @NotBlank
    @Email
    private String email;

}
