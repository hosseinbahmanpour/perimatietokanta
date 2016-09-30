package wad.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Book;
import wad.domain.Narration;
import wad.domain.Narrator;
import wad.domain.Theme;

public interface NarrationRepository extends JpaRepository<Narration, Long> {

    public Collection<Narration> findByBook(Book book);
    public Collection<Narration> findByNarrator(Narrator narrator);
    public Collection<Narration> findByTheme(Theme theme);
    public Collection<Narration> findByContentContainingIgnoreCase(String keyword);
}
