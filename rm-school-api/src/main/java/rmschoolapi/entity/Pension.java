package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PENSION")
@AttributeOverride(name = "id", column = @Column(name = "ID_PENSION"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pension extends AbstractEntity {

    @Size(max = 255)
    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @OneToMany(mappedBy = "pension", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Niveau> niveaux = new ArrayList<>();

    @OneToMany(mappedBy = "pension", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Frais> fraisList = new ArrayList<>();
}
