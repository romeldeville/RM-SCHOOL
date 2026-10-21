package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "NIVEAU")
@AttributeOverride(name = "id", column = @Column(name = "ID_NIVEAU"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Niveau extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @NotNull
    @Min(value = 2, message = "L'âge minimal d'admission doit être au moins 2 ans")
    @Max(value = 30, message = "L'âge minimal d'admission ne peut excéder 30 ans")
    @Column(name = "AGE_MINIMAL_ADMIS", nullable = false)
    private Integer ageMinimalAdmis;

    @NotNull
    @Min(value = 3, message = "L'âge maximal d'admission doit être au moins 3 ans")
    @Max(value = 40, message = "L'âge maximal d'admission ne peut excéder 40 ans")
    @Column(name = "AGE_MAXIMAL_ADMIS", nullable = false)
    private Integer ageMaximalAdmis;

    @NotNull
    @DecimalMin(value = "0.00", message = "La moyenne admise doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La moyenne admise doit être comprise entre 0 et 20")
    @Column(name = "MOYENNE_ADMISE", nullable = false, precision = 15, scale = 2)
    private Double moyenneAdmise;

    @NotNull
    @DecimalMin(value = "0.00", message = "La moyenne de passage doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La moyenne de passage doit être comprise entre 0 et 20")
    @Column(name = "MOYENNE_PASSAGE", nullable = false, precision = 15, scale = 2)
    private Double moyennePassage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PENSION")
    private Pension pension;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CYCLE", nullable = false)
    private Cycle cycle;

    @OneToMany(mappedBy = "niveau", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Classe> classes = new ArrayList<>();

    @OneToMany(mappedBy = "niveau", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CourNiveau> coursNiveau = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "EXAMEN_NIVEAU",
            joinColumns = @JoinColumn(name = "ID_NIVEAU"),
            inverseJoinColumns = @JoinColumn(name = "ID_EXAMEN")
    )
    private List<Examen> examens = new ArrayList<>();
}
