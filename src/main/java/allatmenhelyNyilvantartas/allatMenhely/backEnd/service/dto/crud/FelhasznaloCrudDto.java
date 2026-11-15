package allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FelhasznaloCrudDto {

    @NotBlank
    private String username;

}
