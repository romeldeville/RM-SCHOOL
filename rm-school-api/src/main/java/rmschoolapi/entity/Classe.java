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
@Table(name = "CLASSE")
@AttributeOverride(name = "id", column = @Column(name = "ID_CLASSE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classe extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @NotBlank
    @Size(max = 20)
    @Column(name = "ABREVIATION", nullable = false, length = 20)
    private String abreviation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_NIVEAU", nullable = false)
    private Niveau niveau;

    @OneToMany(mappedBy = "classe", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Inscription> inscriptions = new ArrayList<>();

    @OneToMany(mappedBy = "classe", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CoursEnseignant> coursEnseignants = new ArrayList<>();
}
