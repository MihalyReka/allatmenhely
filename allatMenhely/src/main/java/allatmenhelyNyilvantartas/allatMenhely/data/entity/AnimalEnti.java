package allatmenhelyNyilvantartas.allatMenhely.data.entity;

import allatmenhelyNyilvantartas.allatMenhely.data.enums.EgeszsegAllapot;
import allatmenhelyNyilvantartas.allatMenhely.data.enums.FogadasiAllapot;
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
@Table(name="ALLATOK")

public class AnimalEnti {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;

        @Column(nullable = false, length = 30)
        private   String nev;

        @Column(nullable = false, length = 30)
        private  String fajta;

        @Column(nullable = false, length = 30)
        private String allatTipus;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Neme neme;

        @Column(nullable = true)
        private LocalDate szDatum;

        @Column(nullable = false)
        private LocalDate arrivalDate;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private FogadasiAllapot fogadasiAllapot;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private EgeszsegAllapot egeszsegAllapot;

        @ManyToOne
        @JoinColumn(name = "helyszin_id")
        private HelyszinEnti helyszin;

        @ManyToOne
        @JoinColumn(name = "adopter_id")
        private BefogadoEnti adopter;



}
