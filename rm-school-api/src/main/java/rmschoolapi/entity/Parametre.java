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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "PARAMETRE")
@AttributeOverride(name = "id", column = @Column(name = "ID_PARAMETRE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Parametre extends AbstractEntity {

    @NotNull
    @Min(value = 1, message = "Le nombre d'évaluations trimestrielles doit être au moins 1")
    @Max(value = 10, message = "Le nombre d'évaluations trimestrielles ne peut excéder 10")
    @Column(name = "NOMBRE_EVALUATIONS_TRIMESTRIELLES", nullable = false)
    private Integer nombreEvaluationsTrimestrielles;

    @Size(max = 50)
    @Column(name = "SURFIXE_ENTETE_DOCUMENT", length = 50)
    private String surfixeEnteteDocument;

    @NotNull
    @Column(name = "DATE_RENTREE_SCOLAIRE", nullable = false)
    private LocalDate dateRentreeScolaire;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_INFORMATIONS_ETABLISSEMENT_SCOLAIRE", nullable = false)
    private InformationsEtablissementScolaire informationsEtablissementScolaire;
}
