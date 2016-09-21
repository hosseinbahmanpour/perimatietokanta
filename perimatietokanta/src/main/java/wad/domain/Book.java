package wad.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Book {
    
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private int volume;
    
    @OneToMany(mappedBy = "title")
    private List<Narration> narrations;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<Narration> getNarrations() {
        return narrations;
    }

    public void setNarrations(List<Narration> narrations) {
        this.narrations = narrations;
    }
}
