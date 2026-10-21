package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@Table(name = "GROUPE")
@AttributeOverride(name = "id", column = @Column(name = "ID_GROUPE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Groupe extends AbstractEntity {

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

    @Size(max = 255)
    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @Size(max = 255)
    @Column(name = "DESCRIPTION_ANGLAIS", length = 255)
    private String descriptionAnglais;

    @OneToMany(mappedBy = "groupe", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CourNiveau> coursNiveau = new ArrayList<>();
}
