package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ELEVE")
@AttributeOverride(name = "id", column = @Column(name = "ID_ELEVE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Eleve extends AbstractEntity {

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOM", nullable = false, length = 100)
    private String nom;

    @NotBlank
    @Size(max = 100)
    @Column(name = "PRENOM", nullable = false, length = 100)
    private String prenom;

    @NotNull
    @Past
    @Column(name = "DATE_NAISSANCE", nullable = false)
    private LocalDate dateNaissance;

    @NotBlank
    @Size(max = 100)
    @Column(name = "LIEU_NAISSANCE", nullable = false, length = 100)
    private String lieuNaissance;

    @NotBlank
    @Pattern(regexp = "^[MF]$", message = "Le sexe doit être M ou F")
    @Column(name = "SEXE", nullable = false, length = 1)
    private String sexe;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOM_PERE", nullable = false, length = 100)
    private String nomPere;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOM_MERE", nullable = false, length = 100)
    private String nomMere;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOM_TUTEUR", nullable = false, length = 100)
    private String nomTuteur;

    @NotBlank
    @Size(max = 255)
    @Column(name = "CONTACTS_PARENTS", nullable = false, length = 255)
    private String contactsParents;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPTE_UTILISATEUR", nullable = false, unique = true)
    private CompteUtilisateur compteUtilisateur;

    @OneToMany(mappedBy = "eleve", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Inscription> inscriptions = new ArrayList<>();
}
