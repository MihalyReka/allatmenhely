package allatmenhelyNyilvantartas.allatMenhely.service.dto.crud;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.Neme;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BefogadoTeljesLekeresDto {
    @NotBlank
    private Long id;

    @NotBlank
    private String nev;

    @NotBlank
    private Neme neme;
    @NotBlank
    private LocalDate szDatum;
    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]{9}$")
    private String telefonSzam;

    @NotBlank
    @Email
    private String email;
}
