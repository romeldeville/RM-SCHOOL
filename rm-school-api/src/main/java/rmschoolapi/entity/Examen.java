package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EXAMEN")
@AttributeOverride(name = "id", column = @Column(name = "ID_EXAMEN"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Examen extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Size(max = 50)
    @Column(name = "NOM_ANGLAIS", length = 50)
    private String nomAnglais;

    @NotBlank
    @Size(max = 20)
    @Column(name = "ABREVIATION", nullable = false, length = 20)
    private String abreviation;

    @Size(max = 20)
    @Column(name = "ABREVIATION_ANGLAIS", length = 20)
    private String abreviationAnglais;

    @ManyToMany(mappedBy = "examens")
    private List<Niveau> niveaux = new ArrayList<>();
}
