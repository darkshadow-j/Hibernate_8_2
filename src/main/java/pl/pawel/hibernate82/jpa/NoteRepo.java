package pl.pawel.hibernate82.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.hibernate82.model.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
}
