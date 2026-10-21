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
@Table(name = "PERSONNEL")
@AttributeOverride(name = "id", column = @Column(name = "ID_PERSONNEL"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personnel extends AbstractEntity {

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOM", nullable = false, length = 100)
    private String nom;

    @NotBlank
    @Size(max = 100)
    @Column(name = "PRENOM", nullable = false, length = 100)
    private String prenom;

    @NotBlank
    @Pattern(regexp = "^[MF]$", message = "Le sexe doit être M ou F")
    @Column(name = "SEXE", nullable = false, length = 1)
    private String sexe;

    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = "^[+]?[0-9\\s\\-().]{8,20}$", message = "Contact invalide")
    @Column(name = "CONTACTS", nullable = false, length = 20)
    private String contacts;

    @NotNull
    @Past
    @Column(name = "DATE_NAISSANCE", nullable = false)
    private LocalDate dateNaissance;

    @NotBlank
    @Size(max = 100)
    @Column(name = "LIEU_NAISSANCE", nullable = false, length = 100)
    private String lieuNaissance;

    @Size(max = 50)
    @Column(name = "ETHNIE", length = 50)
    private String ethnie;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOM_PERE", nullable = false, length = 100)
    private String nomPere;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOM_MERE", nullable = false, length = 100)
    private String nomMere;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPTE_UTILISATEUR", nullable = false, unique = true)
    private CompteUtilisateur compteUtilisateur;

    @OneToMany(mappedBy = "personnel", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<InformationsPersonnel> informationsPersonnels = new ArrayList<>();
}
