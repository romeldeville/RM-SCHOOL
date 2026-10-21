package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "PERIODE")
@AttributeOverride(name = "id", column = @Column(name = "ID_PERIODE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Periode extends AbstractEntity {

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

    @NotNull
    @Column(name = "DEBUT", nullable = false)
    private LocalDate debut;

    @NotNull
    @Column(name = "FIN", nullable = false)
    private LocalDate fin;

    @NotNull
    @Column(name = "STATUT", nullable = false)
    private Boolean statut;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ANNEE_SCOLAIRE", nullable = false)
    private AnneeScolaire anneeScolaire;
}
