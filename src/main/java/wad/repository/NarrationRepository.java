package wad.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Book;
import wad.domain.Narration;
import wad.domain.Narrator;
import wad.domain.Theme;

public interface NarrationRepository extends JpaRepository<Narration, Long> {

    Collection<Narration> findByBook(Book book);
    Collection<Narration> findByNarrator(Narrator narrator);
    Collection<Narration> findByTheme(Theme theme);
}
