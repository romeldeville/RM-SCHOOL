package rmschoolapi.dto.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rmschoolapi.dto.AbstractDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformationsEtablissementScolaireBasicDTO extends AbstractDTO {

    private String pays;
    private String paysAnglais;
    private String devisePays;
    private String devisePaysAnglais;
    private String ministere;
    private String ministereAnglais;
    private String region;
    private String regionAnglais;
    private String departement;
    private String departementAnglais;
    private String arrondissement;
    private String arrondissementAnglais;
    private String ville;
    private String villeAnglais;
    private String localisation;
    private String localisationAnglais;
    private String nom;
    private String nomAnglais;
    private String abreviation;
    private String abreviationAnglais;
    private String devise;
    private String deviseAnglais;
    private String telephone;
    private String codePostal;
    private String fax;
    private String email;
    private String logo;
}
