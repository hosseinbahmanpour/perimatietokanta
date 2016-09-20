package wad.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Source extends AbstractPersistable<Long> {

    @OneToOne(mappedBy = "source")
    private Narration narration;

    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    private String page;

    public Narration getNarration() {
        return narration;
    }

    public void setNarration(Narration narration) {
        this.narration = narration;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
