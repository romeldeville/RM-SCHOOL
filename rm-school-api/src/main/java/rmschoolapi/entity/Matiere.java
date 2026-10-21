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
@Table(name = "MATIERE")
@AttributeOverride(name = "id", column = @Column(name = "ID_MATIERE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Matiere extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @NotBlank
    @Size(max = 20)
    @Column(name = "ABREVIATION", nullable = false, length = 20)
    private String abreviation;

    @OneToMany(mappedBy = "matiere", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CourNiveau> coursNiveau = new ArrayList<>();
}
