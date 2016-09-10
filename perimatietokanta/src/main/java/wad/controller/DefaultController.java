package wad.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Book;
import wad.domain.Narration;
import wad.domain.Narrator;
import wad.repository.BookRepository;
import wad.repository.NarrationRepository;
import wad.repository.NarratorRepository;

@Controller
@RequestMapping(value = "*")
public class DefaultController {

    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private NarrationRepository narrationRepo;
    @Autowired
    private NarratorRepository narratorRepo;

    @PostConstruct
    public void init() {
        Book b = new Book();
        b.setAuthor("test book author");
        b.setName("test book name");
        Narrator a = new Narrator();
        a.setName("test narrator name");
        bookRepo.save(b);
        narratorRepo.save(a);
        Narration x = new Narration();
        x.setBook(b);
        x.setNarrator(a);
        x.setContent("test narration content, bla bla bla.");
        narrationRepo.save(x);

    }

    @RequestMapping(method = RequestMethod.GET)
    public String view() {
        return "/index";
    }

}
