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
@Table(name = "CYCLE_")
@AttributeOverride(name = "id", column = @Column(name = "ID_CYCLE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cycle extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Size(max = 50)
    @Column(name = "NOM_ANGLAIS", length = 50)
    private String nomAnglais;

    @Size(max = 255)
    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @Size(max = 255)
    @Column(name = "DESCRIPTION_ANGLAIS", length = 255)
    private String descriptionAnglais;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_SECTION", nullable = false)
    private Section section;

    @OneToMany(mappedBy = "cycle", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Niveau> niveaux = new ArrayList<>();
}
