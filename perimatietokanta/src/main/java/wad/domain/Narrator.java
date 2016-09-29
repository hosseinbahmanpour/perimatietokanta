package wad.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Narrator extends AbstractPersistable<Long> {

    @NotBlank
    private String name;

    @OneToMany(mappedBy = "narrator")
    private List<Narration> narrations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Narration> getNarrations() {
        return narrations;
    }

    public void setNarrations(List<Narration> narrations) {
        this.narrations = narrations;
    }
}
