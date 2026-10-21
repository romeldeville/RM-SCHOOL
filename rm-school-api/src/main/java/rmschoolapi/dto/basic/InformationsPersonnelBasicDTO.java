package rmschoolapi.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.AbstractDTO;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationsPersonnelBasicDTO extends AbstractDTO {

    private String matricule;
    private String diplomeProfessionnel;
    private String disciplineDeFormation;
    private String grade;
    private String posteOccupe;
    private String statut;
    private LocalDate dateArrivee;
    private String referenceActeRecrutement;
    private String regionOrigine;
    private String departementOrigine;
    private String arrondissementOrigine;
    private String situationMatrimoniale;
    private String nomConjoint;
    private String professionConjoint;
    private String diplomeAcademique;
    private Double quotaHoraire;
    private LocalDate dateEntreeFonctionPublique;
    private Integer indiceSolde;
    private Integer indiceCarriere;
    private Integer echelon;
    private String categorie;
    private String corps;
    private LocalDate datePromotion;
    private String referenceTexteNomination;
    private String venantDe;
    private String rangDuPoste;
    private String situationIndemnitaire;
    private LocalDate dateDernierAvancement;
    private String positionActuelle;
}
