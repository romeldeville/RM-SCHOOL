package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ABSENCE_ELEVE")
@AttributeOverride(name = "id", column = @Column(name = "ID_ABSENCE_ELEVE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbsenceEleve extends AbstractEntity {

    @NotNull
    @Column(name = "DATE_APPEL", nullable = false)
    private LocalDate dateAppel;

    @NotNull
    @Column(name = "HEURE_DEBUT", nullable = false)
    private LocalTime heureDebut;

    @NotNull
    @Column(name = "HEURE_FIN", nullable = false)
    private LocalTime heureFin;

    @Size(max = 255)
    @Column(name = "COMMENTAIRE", length = 255)
    private String commentaire;

    @Size(max = 255)
    @Column(name = "JUSTIFICATIF", length = 255)
    private String justificatif;

    @Size(max = 255)
    @Column(name = "DOCUMENT_PATH", length = 255)
    private String documentPath;

    @NotNull
    @Column(name = "VALIDE", nullable = false)
    private Boolean valide;

    @Column(name = "DATE_VALIDATION")
    private LocalDate dateValidation;

    @Column(name = "VALIDE_PAR")
    private Long validePar;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_INSCRIPTION", nullable = false)
    private Inscription inscription;
}
