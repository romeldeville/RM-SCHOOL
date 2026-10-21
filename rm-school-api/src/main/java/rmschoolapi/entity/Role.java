package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
@Table(name = "ROLE")
@AttributeOverride(name = "id", column = @Column(name = "ID_ROLE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractEntity {

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

    @OneToMany(mappedBy = "role", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CompteUtilisateur> compteUtilisateurs = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "ROLE_PRIVILEGE",
            joinColumns = @JoinColumn(name = "ID_ROLE"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRIVILEGE")
    )
    private List<Privilege> privileges = new ArrayList<>();
}
