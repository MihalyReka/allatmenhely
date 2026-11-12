package allatmenhelyNyilvantartas.allatMenhely.service.dto.crud;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.Neme;
import allatmenhelyNyilvantartas.allatMenhely.data.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FelhasznaloElsoCrudDto {
    @NotBlank
    private String username;

    @NotBlank
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
