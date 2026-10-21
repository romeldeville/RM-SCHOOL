package rmschoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rmschoolapi.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
