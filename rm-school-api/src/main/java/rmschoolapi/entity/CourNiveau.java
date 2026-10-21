package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COUR_NIVEAU")
@AttributeOverride(name = "id", column = @Column(name = "ID_COUR_NIVEAU"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourNiveau extends AbstractEntity {

    @NotNull
    @DecimalMin(value = "0.0", message = "Le coefficient doit être positif")
    @DecimalMax(value = "20.0", message = "Le coefficient ne peut excéder 20")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "COEFFICIENT", nullable = false, precision = 15, scale = 2)
    private Double coefficient;

    @NotNull
    @DecimalMin(value = "0.0", message = "Le nombre d'heures hebdomadaires doit être positif")
    @DecimalMax(value = "60.0", message = "Le nombre d'heures hebdomadaires ne peut excéder 60")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "NOMBRE_HEURES_HEBDO", nullable = false, precision = 15, scale = 2)
    private Double nombreHeuresHebdo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_GROUPE", nullable = false)
    private Groupe groupe;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_MATIERE", nullable = false)
    private Matiere matiere;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_NIVEAU", nullable = false)
    private Niveau niveau;

    @OneToMany(mappedBy = "courNiveau", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Competence> competences = new ArrayList<>();

    @OneToMany(mappedBy = "courNiveau", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CoursEnseignant> coursEnseignants = new ArrayList<>();
}
