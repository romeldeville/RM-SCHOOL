package rmschoolapi.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "COMPTE_UTILISATEUR")
@AttributeOverride(name = "id", column = @Column(name = "ID_COMPTE_UTILISATEUR"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompteUtilisateur extends AbstractEntity {

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "LOGIN", nullable = false, length = 50, unique = true)
    private String login;

    @NotBlank
    @Size(min = 8, max = 100)
    @Column(name = "MOT_PASSE", nullable = false, length = 100)
    private String motPasse;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_STATUT_COMPTE_UTILISATEUR", nullable = false)
    private StatutCompteUtilisateur statutCompteUtilisateur;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ROLE", nullable = false)
    private Role role;

    @OneToOne(mappedBy = "compteUtilisateur", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Personnel personnel;

    @OneToOne(mappedBy = "compteUtilisateur", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private Eleve eleve;
}
