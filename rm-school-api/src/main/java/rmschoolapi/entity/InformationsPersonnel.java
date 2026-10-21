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
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INFORMATIONS_PERSONNEL")
@AttributeOverride(name = "id", column = @Column(name = "ID_INFORMATIONS_PERSONNEL"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationsPersonnel extends AbstractEntity {

    @NotBlank
    @Size(max = 30)
    @Column(name = "MATRICULE", nullable = false, length = 30, unique = true)
    private String matricule;

    @Size(max = 100)
    @Column(name = "DIPLOME_PROFESSIONNEL", length = 100)
    private String diplomeProfessionnel;

    @Size(max = 100)
    @Column(name = "DISCIPLINE_DE_FORMATION", length = 100)
    private String disciplineDeFormation;

    @Size(max = 100)
    @Column(name = "GRADE", length = 100)
    private String grade;

    @Size(max = 100)
    @Column(name = "POSTE_OCCUPE", length = 100)
    private String posteOccupe;

    @Size(max = 100)
    @Column(name = "STATUT", length = 100)
    private String statut;

    @PastOrPresent
    @Column(name = "DATE_ARRIVEE")
    private LocalDate dateArrivee;

    @Size(max = 50)
    @Column(name = "REFERENCE_ACTE_RECRUTEMENT", length = 50)
    private String referenceActeRecrutement;

    @Size(max = 100)
    @Column(name = "REGION_ORIGINE", length = 100)
    private String regionOrigine;

    @Size(max = 100)
    @Column(name = "DEPARTEMENT_ORIGINE", length = 100)
    private String departementOrigine;

    @Size(max = 100)
    @Column(name = "ARRONDISSEMENT_ORIGINE", length = 100)
    private String arrondissementOrigine;

    @Size(max = 50)
    @Column(name = "SITUATION_MATRIMONIALE", length = 50)
    private String situationMatrimoniale;

    @Size(max = 100)
    @Column(name = "NOM_CONJOINT", length = 100)
    private String nomConjoint;

    @Size(max = 100)
    @Column(name = "PROFESSION_CONJOINT", length = 100)
    private String professionConjoint;

    @Size(max = 100)
    @Column(name = "DIPLOME_ACADEMIQUE", length = 100)
    private String diplomeAcademique;

    @DecimalMin(value = "0.00", message = "La quota horaire ne peut être négative")
    @DecimalMax(value = "1000.00", message = "La quota horaire ne peut excéder 1000 heures")
    @Column(name = "QUOTA_HORAIRE", precision = 15, scale = 2)
    private Double quotaHoraire;

    @PastOrPresent
    @Column(name = "DATE_ENTREE_FONCTION_PUBLIQUE")
    private LocalDate dateEntreeFonctionPublique;

    @Min(value = 0, message = "L'indice solde ne peut être négatif")
    @Column(name = "INDICE_SOLDE")
    private Integer indiceSolde;

    @Min(value = 0, message = "L'indice carrière ne peut être négatif")
    @Column(name = "INDICE_CARRIERE")
    private Integer indiceCarriere;

    @Min(value = 0, message = "L'échelon ne peut être négatif")
    @Max(value = 100, message = "L'échelon ne peut excéder 100")
    @Column(name = "ECHELON")
    private Integer echelon;

    @Size(max = 100)
    @Column(name = "CATEGORIE", length = 100)
    private String categorie;

    @Size(max = 100)
    @Column(name = "CORPS", length = 100)
    private String corps;

    @PastOrPresent
    @Column(name = "DATE_PROMOTION")
    private LocalDate datePromotion;

    @Size(max = 50)
    @Column(name = "REFERENCE_TEXTE_NOMINATION", length = 50)
    private String referenceTexteNomination;

    @Size(max = 100)
    @Column(name = "VENANT_DE", length = 100)
    private String venantDe;

    @Size(max = 100)
    @Column(name = "RANG_DU_POSTE", length = 100)
    private String rangDuPoste;

    @Size(max = 100)
    @Column(name = "SITUATION_INDEMNITAIRE", length = 100)
    private String situationIndemnitaire;

    @PastOrPresent
    @Column(name = "DATE_DERNIER_AVANCEMENT")
    private LocalDate dateDernierAvancement;

    @Size(max = 100)
    @Column(name = "POSITION_ACTUELLE", length = 100)
    private String positionActuelle;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PERSONNEL", nullable = false)
    private Personnel personnel;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_INFORMATIONS_ETABLISSEMENT_SCOLAIRE", nullable = false)
    private InformationsEtablissementScolaire informationsEtablissementScolaire;

    @OneToMany(mappedBy = "informationsPersonnel", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AbsencePersonnel> absencesPersonnel = new ArrayList<>();

    @OneToMany(mappedBy = "informationsPersonnel", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CoursEnseignant> coursEnseignants = new ArrayList<>();
}
