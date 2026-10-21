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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INSCRIPTION")
@AttributeOverride(name = "id", column = @Column(name = "ID_INSCRIPTION"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inscription extends AbstractEntity {

    @NotNull
    @Column(name = "REDOUBLANT", nullable = false)
    private Boolean redoublant;

    @Size(max = 1000)
    @Column(name = "PHOTO", columnDefinition = "TEXT")
    private String photo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ELEVE", nullable = false)
    private Eleve eleve;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CLASSE", nullable = false)
    private Classe classe;

    @OneToMany(mappedBy = "inscription", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Note> notes = new ArrayList<>();

    @OneToMany(mappedBy = "inscription", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Discipline> disciplines = new ArrayList<>();

    @OneToMany(mappedBy = "inscription", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Paiement> paiements = new ArrayList<>();

    @OneToMany(mappedBy = "inscription", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AbsenceEleve> absencesEleve = new ArrayList<>();
}
