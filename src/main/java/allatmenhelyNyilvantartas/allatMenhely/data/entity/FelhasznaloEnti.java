package allatmenhelyNyilvantartas.allatMenhely.data.entity;


import allatmenhelyNyilvantartas.allatMenhely.data.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="FELHASZNALO")
public class FelhasznaloEnti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Role role;
}
