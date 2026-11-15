package allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.display;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.enums.Role;
import lombok.Data;

@Data
public class FelhasznaloDisplayDto {
    private Long id;
    private String username;
    private Role role;

    private Long dolgozoId;
    private Long befogadoId;
}
