package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long>{
    
}
