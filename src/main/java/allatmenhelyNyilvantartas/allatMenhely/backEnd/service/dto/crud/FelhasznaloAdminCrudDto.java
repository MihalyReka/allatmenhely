package allatmenhelyNyilvantartas.allatMenhely.backEnd.service.dto.crud;

import allatmenhelyNyilvantartas.allatMenhely.backEnd.data.enums.Role;
import lombok.Data;

@Data
public class FelhasznaloAdminCrudDto {

    private String username;
    private String password;
    private Role role;

    private Long dolgozoId;
    private Long befogadoId;
}
