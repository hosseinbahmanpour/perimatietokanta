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
@RequestMapping(value = "/")
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
        Book b = new Book();
        Narrator ntr = new Narrator();
        Theme t = new Theme();
        Narration non = new Narration();
        b.setAuthor("author");
        b.setTitle("title");
        ntr.setName("name");
        t.setTheme("theme");
        bookRepo.save(b);
        narratorRepo.save(ntr);
        themeRepo.save(t);
        non.setBook(b);
        non.setContent("blaablaa");
        non.setNarrator(ntr);
        non.setTheme(t);
        narrationRepo.save(non);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String view() {
        return "index";
    }
}
