package allatmenhelyNyilvantartas.allatMenhely.service.dto.crud;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GondozoCrudDto {

    @NotNull
    private Long dolgozoId;
}