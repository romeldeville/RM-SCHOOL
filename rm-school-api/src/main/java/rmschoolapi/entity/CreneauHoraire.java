package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "CRENEAU_HORAIRE")
@AttributeOverride(name = "id", column = @Column(name = "ID_CRENEAU_HORAIRE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreneauHoraire extends AbstractEntity {

    @NotNull
    @Column(name = "HEURE_DEBUT", nullable = false)
    private LocalTime heureDebut;

    @NotNull
    @Column(name = "HEURE_FIN", nullable = false)
    private LocalTime heureFin;

    @NotNull
    @Min(value = 1, message = "L'ordre du créneau doit être au moins 1")
    @Max(value = 30, message = "L'ordre du créneau ne peut excéder 30")
    @Column(name = "ORDRE", nullable = false)
    private Integer ordre;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_TYPE_CRENEAU", nullable = false)
    private TypeCreneau typeCreneau;
}
