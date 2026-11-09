package allatmenhelyNyilvantartas.allatMenhely.service.dto.display;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.Neme;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@Data
 @Mapper
public class BefogadoDisplayDto {
     //@NotBlank
    // private Long id;

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
