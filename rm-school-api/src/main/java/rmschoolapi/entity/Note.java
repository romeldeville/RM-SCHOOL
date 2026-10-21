package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NOTE")
@AttributeOverride(name = "id", column = @Column(name = "ID_NOTE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note extends AbstractEntity {

    @DecimalMin(value = "0.00", message = "La note doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La note doit être comprise entre 0 et 20")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "PREMIERE_EVALUATION", precision = 15, scale = 2)
    private Double premiereEvaluation;

    @DecimalMin(value = "0.00", message = "La note doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La note doit être comprise entre 0 et 20")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "DEUXIEME_EVALUATION", precision = 15, scale = 2)
    private Double deuxiemeEvaluation;

    @DecimalMin(value = "0.00", message = "La note doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La note doit être comprise entre 0 et 20")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "TROISIEME_EVALUATION", precision = 15, scale = 2)
    private Double troisiemeEvaluation;

    @DecimalMin(value = "0.00", message = "La note doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La note doit être comprise entre 0 et 20")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "QUATRIEME_EVALUATION", precision = 15, scale = 2)
    private Double quatriemeEvaluation;

    @DecimalMin(value = "0.00", message = "La note doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La note doit être comprise entre 0 et 20")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "CINQUIEME_EVALUATION", precision = 15, scale = 2)
    private Double cinquiemeEvaluation;

    @DecimalMin(value = "0.00", message = "La note doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La note doit être comprise entre 0 et 20")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "SIXIEME_EVALUATION", precision = 15, scale = 2)
    private Double sixiemeEvaluation;

    @DecimalMin(value = "0.00", message = "La note doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La note doit être comprise entre 0 et 20")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "SEPTIEME_EVALUATION", precision = 15, scale = 2)
    private Double septiemeEvaluation;

    @DecimalMin(value = "0.00", message = "La note doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La note doit être comprise entre 0 et 20")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "HUITIEME_EVALUATION", precision = 15, scale = 2)
    private Double huitiemeEvaluation;

    @DecimalMin(value = "0.00", message = "La note doit être comprise entre 0 et 20")
    @DecimalMax(value = "20.00", message = "La note doit être comprise entre 0 et 20")
    @Digits(integer = 2, fraction = 2)
    @Column(name = "NEUVIEME_EVALUATION", precision = 15, scale = 2)
    private Double neuviemeEvaluation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_INSCRIPTION", nullable = false)
    private Inscription inscription;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_COURS_ENSEIGNANT", nullable = false)
    private CoursEnseignant coursEnseignant;
}
