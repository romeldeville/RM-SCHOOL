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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INFORMATIONS_ETABLISSEMENT_SCOLAIRE")
@AttributeOverride(name = "id", column = @Column(name = "ID_INFORMATIONS_ETABLISSEMENT_SCOLAIRE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationsEtablissementScolaire extends AbstractEntity {

    @NotBlank
    @Size(max = 100)
    @Column(name = "PAYS", nullable = false, length = 100)
    private String pays;

    @Size(max = 100)
    @Column(name = "PAYS_ANGLAIS", length = 100)
    private String paysAnglais;

    @NotBlank
    @Size(max = 100)
    @Column(name = "DEVISE_PAYS", nullable = false, length = 100)
    private String devisePays;

    @Size(max = 100)
    @Column(name = "DEVISE_PAYS_ANGLAIS", length = 100)
    private String devisePaysAnglais;

    @NotBlank
    @Size(max = 100)
    @Column(name = "MINISTERE", nullable = false, length = 100)
    private String ministere;

    @Size(max = 100)
    @Column(name = "MINISTERE_ANGLAIS", length = 100)
    private String ministereAnglais;

    @NotBlank
    @Size(max = 100)
    @Column(name = "REGION", nullable = false, length = 100)
    private String region;

    @Size(max = 100)
    @Column(name = "REGION_ANGLAIS", length = 100)
    private String regionAnglais;

    @NotBlank
    @Size(max = 100)
    @Column(name = "DEPARTEMENT", nullable = false, length = 100)
    private String departement;

    @Size(max = 100)
    @Column(name = "DEPARTEMENT_ANGLAIS", length = 100)
    private String departementAnglais;

    @NotBlank
    @Size(max = 100)
    @Column(name = "ARRONDISSEMENT", nullable = false, length = 100)
    private String arrondissement;

    @Size(max = 100)
    @Column(name = "ARRONDISSEMENT_ANGLAIS", length = 100)
    private String arrondissementAnglais;

    @NotBlank
    @Size(max = 100)
    @Column(name = "VILLE", nullable = false, length = 100)
    private String ville;

    @Size(max = 100)
    @Column(name = "VILLE_ANGLAIS", length = 100)
    private String villeAnglais;

    @Size(max = 255)
    @Column(name = "LOCALISATION", length = 255)
    private String localisation;

    @Size(max = 255)
    @Column(name = "LOCALISATION_ANGLAIS", length = 255)
    private String localisationAnglais;

    @NotBlank
    @Size(max = 100)
    @Column(name = "NOM", nullable = false, length = 100)
    private String nom;

    @Size(max = 100)
    @Column(name = "NOM_ANGLAIS", length = 100)
    private String nomAnglais;

    @NotBlank
    @Size(max = 20)
    @Column(name = "ABREVIATION", nullable = false, length = 20)
    private String abreviation;

    @Size(max = 20)
    @Column(name = "ABREVIATION_ANGLAIS", length = 20)
    private String abreviationAnglais;

    @NotBlank
    @Size(max = 100)
    @Column(name = "DEVISE", nullable = false, length = 100)
    private String devise;

    @Size(max = 100)
    @Column(name = "DEVISE_ANGLAIS", length = 100)
    private String deviseAnglais;

    @NotBlank
    @Size(max = 20)
    @Pattern(regexp = "^[+]?[0-9\\s\\-().]{8,20}$", message = "Téléphone invalide")
    @Column(name = "TELEPHONE", nullable = false, length = 20)
    private String telephone;

    @Size(max = 10)
    @Pattern(regexp = "^[0-9A-Za-z\\-\\s]{3,10}$", message = "Code postal invalide")
    @Column(name = "CODE_POSTAL", length = 10)
    private String codePostal;

    @Size(max = 20)
    @Pattern(regexp = "^[+]?[0-9\\s\\-().]{8,20}$", message = "Fax invalide")
    @Column(name = "FAX", length = 20)
    private String fax;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Size(max = 1000)
    @Column(name = "LOGO", columnDefinition = "TEXT")
    private String logo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ANNEE_SCOLAIRE", nullable = false)
    private AnneeScolaire anneeScolaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ETABLISSEMENT_SCOLAIRE", nullable = false)
    private EtablissementScolaire etablissementScolaire;

    @OneToMany(mappedBy = "informationsEtablissementScolaire", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Parametre> parametres = new ArrayList<>();

    @OneToMany(mappedBy = "informationsEtablissementScolaire", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Depense> depenses = new ArrayList<>();

    @OneToMany(mappedBy = "informationsEtablissementScolaire", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Section> sections = new ArrayList<>();

    @OneToMany(mappedBy = "informationsEtablissementScolaire", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<InformationsPersonnel> informationsPersonnels = new ArrayList<>();
}
