package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "JOUR_SEMAINE")
@AttributeOverride(name = "id", column = @Column(name = "ID_JOUR_SEMAINE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JourSemaine extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Size(max = 50)
    @Column(name = "NOM_ANGLAIS", length = 50)
    private String nomAnglais;

    @NotBlank
    @Size(max = 10)
    @Column(name = "ABREVIATION", nullable = false, length = 10)
    private String abreviation;

    @Size(max = 10)
    @Column(name = "ABREVIATION_ANGLAIS", length = 10)
    private String abreviationAnglais;

    @NotNull
    @Min(value = 1, message = "L'ordre du jour doit être compris entre 1 et 7")
    @Max(value = 7, message = "L'ordre du jour doit être compris entre 1 et 7")
    @Column(name = "ORDRE", nullable = false)
    private Integer ordre;

    @OneToMany(mappedBy = "jourSemaine", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LigneEmploiDuTemps> ligneEmploiDuTempsList = new ArrayList<>();
}
