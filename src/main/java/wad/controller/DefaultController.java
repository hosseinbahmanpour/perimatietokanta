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

    // Luodaan jotain tietoja testausta varten
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

        Book b1 = new Book();
        b1.setAuthor("George Bush");
        b1.setTitle("Why I'm Stupid");
        bookRepo.save(b1);

        Book b2 = new Book();
        b2.setAuthor("Harrison Ford");
        b2.setTitle("The Man, The Legend");
        bookRepo.save(b2);

        Narrator n1 = new Narrator();
        n1.setName("Muhammad Ali");
        narratorRepo.save(n1);

        Narrator n2 = new Narrator();
        n1.setName("Arnold");
        narratorRepo.save(n2);

        Narrator n3 = new Narrator();
        n1.setName("Stallone");
        narratorRepo.save(n3);

        Theme t1 = new Theme();
        t1.setTheme("War");
        themeRepo.save(t1);

        Theme t2 = new Theme();
        t2.setTheme("Peace");
        themeRepo.save(t2);

        Narration non1 = new Narration();
        non1.setContent("I am the greatest!");
        non1.setBook(b2);
        non1.setTheme(t2);
        non1.setNarrator(n1);
        narrationRepo.save(non1);

        Narration non2 = new Narration();
        non1.setContent("I'll be back.");
        non1.setBook(b1);
        non1.setTheme(t1);
        non1.setNarrator(n2);
        narrationRepo.save(non2);

        Narration non3 = new Narration();
        non1.setContent("Stupid is what stupid does");
        non1.setBook(b1);
        non1.setTheme(t1);
        non1.setNarrator(n3);
        narrationRepo.save(non3);

        Narration non4 = new Narration();
        non1.setContent("Sting like a bee!");
        non1.setBook(b2);
        non1.setTheme(t2);
        non1.setNarrator(n1);
        narrationRepo.save(non4);

        Narration non5 = new Narration();
        non1.setContent("Hasta la vista, baby.");
        non1.setBook(b1);
        non1.setTheme(t1);
        non1.setNarrator(n2);
        narrationRepo.save(non5);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String view() {
        return "index";
    }
}
