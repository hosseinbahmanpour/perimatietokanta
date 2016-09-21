package wad.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Theme extends AbstractPersistable<Long> {

    @NotBlank
    private String theme;

    @OneToMany(mappedBy = "theme")
    private List<Narration> narrations;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Narration> getNarrations() {
        return narrations;
    }

    public void setNarrations(List<Narration> narrations) {
        this.narrations = narrations;
    }
}
