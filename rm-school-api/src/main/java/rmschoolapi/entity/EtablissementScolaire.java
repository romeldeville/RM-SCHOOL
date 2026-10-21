package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
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
@Table(name = "ETABLISSEMENT_SCOLAIRE")
@AttributeOverride(name = "id", column = @Column(name = "ID_ETABLISSEMENT_SCOLAIRE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementScolaire extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "IMMATRICULATION", nullable = false, length = 50)
    private String immatriculation;

    @PastOrPresent
    @Column(name = "DATE_CREATION")
    private LocalDate dateCreation;

    @PastOrPresent
    @Column(name = "DATE_OUVERTURE")
    private LocalDate dateOuverture;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOM_FONDATEUR", nullable = false, length = 100)
    private String nomFondateur;

    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = "^[+]?[0-9\\s\\-().]{8,20}$", message = "Contact fondateur invalide")
    @Column(name = "CONTACT_FONDATEUR", nullable = false, length = 20)
    private String contactFondateur;

    @OneToMany(mappedBy = "etablissementScolaire", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<InformationsEtablissementScolaire> informationsEtablissementScolaires = new ArrayList<>();
}
