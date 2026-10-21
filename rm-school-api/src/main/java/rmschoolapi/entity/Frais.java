package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "FRAIS")
@AttributeOverride(name = "id", column = @Column(name = "ID_FRAIS"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Frais extends AbstractEntity {

    @NotBlank
    @Size(max = 50)
    @Column(name = "NOM", nullable = false, length = 50)
    private String nom;

    @Size(max = 255)
    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @NotNull
    @Positive(message = "Le montant du frais doit être strictement positif")
    @Digits(integer = 12, fraction = 2)
    @Column(name = "MONTANT", nullable = false, precision = 15, scale = 2)
    private Double montant;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PENSION", nullable = false)
    private Pension pension;
}
