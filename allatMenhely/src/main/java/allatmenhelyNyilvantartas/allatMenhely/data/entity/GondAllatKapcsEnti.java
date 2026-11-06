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
@Table(name="GONDO_ALLAT_KAPCS")
public class GondAllatKapcsEnti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "gondozo_id", nullable = false)
    private GondozoEnti gondozo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "animal_id", nullable = false)
    private AnimalEnti animal;

    @Column(nullable = false)
    private LocalDate kezdet;

    @Column(nullable = true)
    private LocalDate eddig;
}
