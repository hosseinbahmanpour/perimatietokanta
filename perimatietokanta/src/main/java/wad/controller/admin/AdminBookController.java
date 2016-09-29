package wad.controller.admin;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Book;
import wad.domain.Narration;
import wad.repository.BookRepository;
import wad.repository.NarrationRepository;
import wad.repository.NarratorRepository;
import wad.repository.ThemeRepository;

@Controller
@RequestMapping(value = "admin")
public class AdminBookController {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private NarrationRepository narrationRepo;

    @Autowired
    private NarratorRepository narratorRepo;

    @Autowired
    private ThemeRepository themeRepo;

    @RequestMapping(value = "book", method = RequestMethod.POST)
    public String createBook(@RequestParam String title,
            @RequestParam String author) {

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookRepo.save(book);

        return "redirect:/books";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {

        Collection<Narration> narrations = narrationRepo.findByBook(bookRepo.findOne(id));

        narrations.stream().forEach((n) -> {
            narratorRepo.findOne(n.getNarrator().getId()).getNarrations().remove(n);
            themeRepo.findOne(n.getNarrator().getId()).getNarrations().remove(n);
            narrationRepo.delete(n);
        });

        bookRepo.delete(id);
        return "redirect:/books";
    }

    @RequestMapping(value = "editbook/{id}", method = RequestMethod.GET)
    public String viewBookEditor(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepo.findOne(id));
        return "editbook";
    }

    @RequestMapping(value = "editbook/{id}", method = RequestMethod.POST)
    public String editBook(@PathVariable Long id, @RequestParam String title,
            @RequestParam String author, Model model) {

        Book book = bookRepo.findOne(id);
        book.setAuthor(author);
        book.setTitle(title);
        bookRepo.save(book);

        return "redirect:/books";
    }
}
