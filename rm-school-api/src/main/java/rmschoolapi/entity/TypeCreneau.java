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
@Table(name = "TYPE_CRENEAU")
@AttributeOverride(name = "id", column = @Column(name = "ID_TYPE_CRENEAU"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeCreneau extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Size(max = 50)
    @Column(name = "NOM_ANGLAIS", length = 50)
    private String nomAnglais;

    @NotNull
    @Min(value = 10, message = "La durée minimale d'un créneau est de 10 minutes")
    @Max(value = 480, message = "La durée maximale d'un créneau est de 480 minutes")
    @Column(name = "DUREE_MINUTES", nullable = false)
    private Integer dureeMinutes;

    @OneToMany(mappedBy = "typeCreneau", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CreneauHoraire> creneauxHoraires = new ArrayList<>();
}
