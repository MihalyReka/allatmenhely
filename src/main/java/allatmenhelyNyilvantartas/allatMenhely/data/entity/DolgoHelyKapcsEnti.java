package allatmenhelyNyilvantartas.allatMenhely.data.entity;


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
@Table(name="DOLG_HELY_KAPCS")
public class DolgoHelyKapcsEnti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dolgozo_id", nullable = false)
    private DolgozoEnti dolgozo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "helyszin_id", nullable = false)
    private HelyszinEnti helyszin;

    @Column(nullable = false)
    private LocalDate kezdes;

    @Column(nullable = true)
    private LocalDate eddig;


}
