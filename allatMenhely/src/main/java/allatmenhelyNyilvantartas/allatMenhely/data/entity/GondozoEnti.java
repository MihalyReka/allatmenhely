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
@Table(name="GONDOZO")
public class GondozoEnti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "dolgozo_id", nullable = false, unique = true)
    private DolgozoEnti dolgozo;



}
