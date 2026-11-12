package allatmenhelyNyilvantartas.allatMenhely.service.dto.crud;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.Role;
import lombok.Data;

@Data
public class FelhasznaloAdminCrudDto {

    private String username;
    private String password;
    private Role role;

    private Long dolgozoId;
    private Long befogadoId;
}
