package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Source;

public interface SourceRepository extends JpaRepository<Source, Long> {
    
}
