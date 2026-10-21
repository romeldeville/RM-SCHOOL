package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COMPETENCE")
@AttributeOverride(name = "id", column = @Column(name = "ID_COMPETENCE"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Competence extends AbstractEntity {

    @Size(max = 255)
    @Column(name = "COMPETENCE_PREMIERE_EVALUATION", length = 255)
    private String competencePremiereEvaluation;

    @Size(max = 255)
    @Column(name = "COMPETENCE_DEUXIEME_EVALUATION", length = 255)
    private String competenceDeuxiemeEvaluation;

    @Size(max = 255)
    @Column(name = "COMPETENCE_TROISIEME_EVALUATION", length = 255)
    private String competenceTroisiemeEvaluation;

    @Size(max = 255)
    @Column(name = "COMPETENCE_QUATRIEME_EVALUATION", length = 255)
    private String competenceQuatriemeEvaluation;

    @Size(max = 255)
    @Column(name = "COMPETENCE_CINQUIEME_EVALUATION", length = 255)
    private String competenceCinquiemeEvaluation;

    @Size(max = 255)
    @Column(name = "COMPETENCE_SIXIEME_EVALUATION", length = 255)
    private String competenceSixiemeEvaluation;

    @Size(max = 255)
    @Column(name = "COMPETENCE_SEPTIEME_EVALUATION", length = 255)
    private String competenceSeptiemeEvaluation;

    @Size(max = 255)
    @Column(name = "COMPETENCE_HUITIEME_EVALUATION", length = 255)
    private String competenceHuitiemeEvaluation;

    @Size(max = 255)
    @Column(name = "COMPETENCE_NEUVIEME_EVALUATION", length = 255)
    private String competenceNeuviemeEvaluation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_COUR_NIVEAU", nullable = false)
    private CourNiveau courNiveau;
}
