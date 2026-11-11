package allatmenhelyNyilvantartas.allatMenhely.service.dto.crud;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GondAllatKapcsCrudDto {

/**/
    @NotNull
    private Long gondozoId;

    @NotNull
    private Long animalId;

    @NotNull
    private LocalDate kezdet;

    private LocalDate eddig;
}
