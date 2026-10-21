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
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "DEPENSE")
@AttributeOverride(name = "id", column = @Column(name = "ID_DEPENSE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Depense extends AbstractEntity {

    @NotBlank
    @Size(max = 255)
    @Column(name = "MOTIF", nullable = false, length = 255)
    private String motif;

    @NotNull
    @PastOrPresent
    @Column(name = "DATE_DEPENSE", nullable = false)
    private LocalDateTime dateDepense;

    @NotNull
    @Positive(message = "Le montant de la dépense doit être strictement positif")
    @Digits(integer = 12, fraction = 2)
    @Column(name = "MONTANT", nullable = false, precision = 15, scale = 2)
    private Double montant;

    @NotBlank
    @Pattern(regexp = "^[A-Z]{3}$", message = "La devise doit être un code ISO 4217 (ex : XAF)")
    @Column(name = "DEVISE", nullable = false, length = 3)
    private String devise;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_INFORMATIONS_ETABLISSEMENT_SCOLAIRE", nullable = false)
    private InformationsEtablissementScolaire informationsEtablissementScolaire;
}
