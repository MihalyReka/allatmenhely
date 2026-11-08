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
@Table(name="DOLGOZO")
public class DolgozoEnti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, length = 30)
    private   String nev;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Neme neme;

    @Column(nullable = true)
    private LocalDate szDatum;

    @Column(nullable = false,unique = true, length = 20)
    private String telefonSzam;

    @Column(nullable = false,unique = true,length = 40)
    private String email;

    @Column(nullable = false, length = 50)
    private   String beosztas;

    /*
    @Column(nullable = false)
    private Boolean active;
    */

}
