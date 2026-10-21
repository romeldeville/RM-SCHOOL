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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "COURS_ENSEIGNANT")
@AttributeOverride(name = "id", column = @Column(name = "ID_COURS_ENSEIGNANT"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoursEnseignant extends AbstractEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_COUR_NIVEAU", nullable = false)
    private CourNiveau courNiveau;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLASSE", nullable = false)
    private Classe classe;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_INFORMATIONS_PERSONNEL", nullable = false)
    private InformationsPersonnel informationsPersonnel;

    @OneToMany(mappedBy = "coursEnseignant", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Note> notes = new ArrayList<>();

    @OneToMany(mappedBy = "coursEnseignant", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LigneEmploiDuTemps> ligneEmploiDuTempsList = new ArrayList<>();
}
