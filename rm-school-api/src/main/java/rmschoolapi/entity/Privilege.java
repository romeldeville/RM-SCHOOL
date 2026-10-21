package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Table(name = "PRIVILEGE")
@AttributeOverride(name = "id", column = @Column(name = "ID_PRIVILEGE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Privilege extends AbstractEntity {

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
    @Column(name = "STATUT", nullable = false)
    private Boolean statut;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles = new ArrayList<>();
}
