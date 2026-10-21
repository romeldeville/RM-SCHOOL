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

@Entity
@Table(name = "DISCIPLINE")
@AttributeOverride(name = "id", column = @Column(name = "ID_DISCIPLINE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discipline extends AbstractEntity {

    @Min(value = 0, message = "Le nombre de retards ne peut être négatif")
    @Column(name = "RETARDS_TRIMESTRE_1")
    private Integer retardsTrimestre1;

    @Min(value = 0, message = "Le nombre de retards ne peut être négatif")
    @Column(name = "RETARDS_TRIMESTRE_2")
    private Integer retardsTrimestre2;

    @Min(value = 0, message = "Le nombre de retards ne peut être négatif")
    @Column(name = "RETARDS_TRIMESTRE_3")
    private Integer retardsTrimestre3;

    @Min(value = 0, message = "Le nombre d'absences ne peut être négatif")
    @Column(name = "ABSENCES_NON_JUSTIFIEES_TRIMESTRE_1")
    private Integer absencesNonJustifieesTrimestre1;

    @Min(value = 0, message = "Le nombre d'absences ne peut être négatif")
    @Column(name = "ABSENCES_NON_JUSTIFIEES_TRIMESTRE_2")
    private Integer absencesNonJustifieesTrimestre2;

    @Min(value = 0, message = "Le nombre d'absences ne peut être négatif")
    @Column(name = "ABSENCES_NON_JUSTIFIEES_TRIMESTRE_3")
    private Integer absencesNonJustifieesTrimestre3;

    @Min(value = 0, message = "Le nombre d'absences ne peut être négatif")
    @Column(name = "ABSENCES_JUSTIFIEES_TRIMESTRE_1")
    private Integer absencesJustifieesTrimestre1;

    @Min(value = 0, message = "Le nombre d'absences ne peut être négatif")
    @Column(name = "ABSENCES_JUSTIFIEES_TRIMESTRE_2")
    private Integer absencesJustifieesTrimestre2;

    @Min(value = 0, message = "Le nombre d'absences ne peut être négatif")
    @Column(name = "ABSENCES_JUSTIFIEES_TRIMESTRE_3")
    private Integer absencesJustifieesTrimestre3;

    @Min(value = 0, message = "Le nombre de blâmes ne peut être négatif")
    @Column(name = "BLAMES_TRIMESTRE_1")
    private Integer blamesTrimestre1;

    @Min(value = 0, message = "Le nombre de blâmes ne peut être négatif")
    @Column(name = "BLAMES_TRIMESTRE_2")
    private Integer blamesTrimestre2;

    @Min(value = 0, message = "Le nombre de blâmes ne peut être négatif")
    @Column(name = "BLAMES_TRIMESTRE_3")
    private Integer blamesTrimestre3;

    @Min(value = 0, message = "Le nombre d'exclusions ne peut être négatif")
    @Max(value = 365, message = "Le nombre d'exclusions est irréaliste")
    @Column(name = "EXCLUSIONS_TRIMESTRE_1")
    private Integer exclusionsTrimestre1;

    @Min(value = 0, message = "Le nombre d'exclusions ne peut être négatif")
    @Max(value = 365, message = "Le nombre d'exclusions est irréaliste")
    @Column(name = "EXCLUSIONS_TRIMESTRE_2")
    private Integer exclusionsTrimestre2;

    @Min(value = 0, message = "Le nombre d'exclusions ne peut être négatif")
    @Max(value = 365, message = "Le nombre d'exclusions est irréaliste")
    @Column(name = "EXCLUSIONS_TRIMESTRE_3")
    private Integer exclusionsTrimestre3;

    @Min(value = 0, message = "Le nombre d'avertissements ne peut être négatif")
    @Column(name = "AVERTISSEMENTS_TRIMESTRE_1")
    private Integer avertissementsTrimestre1;

    @Min(value = 0, message = "Le nombre d'avertissements ne peut être négatif")
    @Column(name = "AVERTISSEMENTS_TRIMESTRE_2")
    private Integer avertissementsTrimestre2;

    @Min(value = 0, message = "Le nombre d'avertissements ne peut être négatif")
    @Column(name = "AVERTISSEMENTS_TRIMESTRE_3")
    private Integer avertissementsTrimestre3;

    @Min(value = 0, message = "Le nombre de retenues ne peut être négatif")
    @Column(name = "RETENUES_TRIMESTRE_1")
    private Integer retenuesTrimestre1;

    @Min(value = 0, message = "Le nombre de retenues ne peut être négatif")
    @Column(name = "RETENUES_TRIMESTRE_2")
    private Integer retenuesTrimestre2;

    @Min(value = 0, message = "Le nombre de retenues ne peut être négatif")
    @Column(name = "RETENUES_TRIMESTRE_3")
    private Integer retenuesTrimestre3;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_INSCRIPTION", nullable = false)
    private Inscription inscription;
}
