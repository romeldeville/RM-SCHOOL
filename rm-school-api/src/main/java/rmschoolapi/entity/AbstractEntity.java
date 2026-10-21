package rmschoolapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "DATE_ENREGISTREMENT", updatable = false)
    private LocalDateTime dateEnregistrement;

    @UpdateTimestamp
    @Column(name = "DATE_MODIFICATION")
    private LocalDateTime dateModification;

    @Column(name = "RESPONSABLE_ENREGISTREMENT")
    private Long responsableEnregistrement;

    @Column(name = "RESPONSABLE_MODIFICATION")
    private Long responsableModification;
}
