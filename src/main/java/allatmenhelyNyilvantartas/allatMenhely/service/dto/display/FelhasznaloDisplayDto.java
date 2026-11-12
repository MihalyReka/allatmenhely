package allatmenhelyNyilvantartas.allatMenhely.service.dto.display;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.Role;
import lombok.Data;

@Data
public class FelhasznaloDisplayDto {
    private Long id;
    private String username;
    private Role role;

    private Long dolgozoId;
    private Long befogadoId;
}
