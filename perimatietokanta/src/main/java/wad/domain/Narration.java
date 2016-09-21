package wad.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Narration extends AbstractPersistable<Long> {

    @NotBlank
    private String content;
    @NotBlank
    private int sourcePage;

    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;
    
    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    private Narrator narrator;
    
    @NotBlank
    @ManyToOne(fetch = FetchType.LAZY)
    private Theme theme;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSourcePage() {
        return sourcePage;
    }

    public void setSourcePage(int sourcePage) {
        this.sourcePage = sourcePage;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Narrator getNarrator() {
        return narrator;
    }

    public void setNarrator(Narrator narrator) {
        this.narrator = narrator;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
  }
