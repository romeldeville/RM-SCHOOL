package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LIGNE_EMPLOI_DU_TEMPS")
@AttributeOverride(name = "id", column = @Column(name = "ID_LIGNE_EMPLOI_DU_TEMPS"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LigneEmploiDuTemps extends AbstractEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_JOUR_SEMAINE", nullable = false)
    private JourSemaine jourSemaine;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CRENEAU_HORAIRE", nullable = false)
    private CreneauHoraire creneauHoraire;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_COURS_ENSEIGNANT", nullable = false)
    private CoursEnseignant coursEnseignant;
}
