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
@Table(name = "ABSENCE_PERSONNEL")
@AttributeOverride(name = "id", column = @Column(name = "ID_ABSENCE_PERSONNEL"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbsencePersonnel extends AbstractEntity {

    @NotNull
    @Column(name = "DATE_ABSENCE", nullable = false)
    private LocalDate dateAbsence;

    @NotNull
    @Column(name = "HEURE_DEBUT", nullable = false)
    private LocalTime heureDebut;

    @NotNull
    @Column(name = "HEURE_FIN", nullable = false)
    private LocalTime heureFin;

    @Size(max = 255)
    @Column(name = "MOTIF", length = 255)
    private String motif;

    @Size(max = 50)
    @Column(name = "TYPE_ABSENCE", length = 50)
    private String typeAbsence;

    @Size(max = 255)
    @Column(name = "COMMENTAIRE", length = 255)
    private String commentaire;

    @Size(max = 255)
    @Column(name = "DOCUMENT_PATH", length = 255)
    private String documentPath;

    @NotNull
    @Column(name = "APPROUVE", nullable = false)
    private Boolean approuve;

    @Column(name = "DATE_APPROBATION")
    private LocalDate dateApprobation;

    @Column(name = "APPROUVE_PAR")
    private Long approuvePar;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_INFORMATIONS_PERSONNEL", nullable = false)
    private InformationsPersonnel informationsPersonnel;
}
