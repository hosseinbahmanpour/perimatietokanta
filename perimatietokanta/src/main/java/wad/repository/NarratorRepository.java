package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Narrator;

public interface NarratorRepository extends JpaRepository<Narrator, Long>{
    
}
