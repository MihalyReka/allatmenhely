package allatmenhelyNyilvantartas.allatMenhely.service.dto.display;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GondAllatKapcsDisplayDto {
    @NotNull
    private Long gondozoId;

    @NotNull
    private Long animalId;

    @NotNull
    private LocalDate kezdet;

    private LocalDate eddig;

}
