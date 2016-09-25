package wad.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Book;
import wad.domain.Narration;
import wad.domain.Narrator;
import wad.domain.Theme;
import wad.repository.BookRepository;
import wad.repository.NarrationRepository;
import wad.repository.NarratorRepository;
import wad.repository.ThemeRepository;

@Controller
@RequestMapping(value = "*")
public class DefaultController {
    
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private NarrationRepository narrationRepo;
    @Autowired
    private NarratorRepository narratorRepo;
    @Autowired
    private ThemeRepository themeRepo;

    @PostConstruct
    public void init() {

        Narrator narrator = new Narrator();
        narrator.setName("test narrator name");
        narratorRepo.save(narrator);

        Theme theme = new Theme();
        theme.setTheme("test theme");
        themeRepo.save(theme);

        Book book = new Book();
        book.setTitle("test book title");
        book.setAuthor("test book author");
        bookRepo.save(book);
        
        Narration narration = new Narration();
        narration.setNarrator(narrator);
        narration.setTheme(theme);
        narration.setBook(book);
        narration.setContent("test narration content, bla bla bla.");
        narration.setPage(1);
        narrationRepo.save(narration);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String view() {
        return "index";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET) 
    public String login() {
        return "redirect:/login";
    }
}
