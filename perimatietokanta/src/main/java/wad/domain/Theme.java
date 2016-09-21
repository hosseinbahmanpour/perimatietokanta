package wad.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Theme {

    private String theme;

    @OneToMany(mappedBy = "theme")
    private List<Narration> narration;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Narration> getNarration() {
        return narration;
    }

    public void setNarration(List<Narration> narration) {
        this.narration = narration;
    }
}
