package allatmenhelyNyilvantartas.allatMenhely.data.entity;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.Neme;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="HELYSZIN")
public class HelyszinEnti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = true, length = 30)
    private   String nev;

    @Column(nullable = false)
    private int befogadasSzam;

    @Column(nullable = false)
    private int letszam;

    @Column(nullable = true, length = 250)
    private   String leiras;
}
