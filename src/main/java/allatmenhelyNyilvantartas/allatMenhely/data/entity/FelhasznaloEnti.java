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

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToOne
    @JoinColumn(name = "dolgozo_id", unique = true)
    private DolgozoEnti dolgozo;

    @OneToOne
    @JoinColumn(name = "befogado_id", unique = true)
    private BefogadoEnti befogado;
}
