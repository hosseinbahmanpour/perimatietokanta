package wad.controller;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Source;
import wad.domain.Narration;
import wad.domain.Narrator;
import wad.repository.NarrationRepository;
import wad.repository.NarratorRepository;
import wad.repository.SourceRepository;

@Controller
@RequestMapping(value = "*")
public class DefaultController {

    @Autowired
    private SourceRepository bookRepo;
    @Autowired
    private NarrationRepository narrationRepo;
    @Autowired
    private NarratorRepository narratorRepo;

    @PostConstruct
    public void init() {
        Source source = new Source();
        source.setAuthor("test book author");
        source.setBook("test book");
        source.setPage(1);
        source.setVolume(1);
        Narrator narrator = new Narrator();
        narrator.setName("test narrator name");
        bookRepo.save(source);
        narratorRepo.save(narrator);
        Narration narration = new Narration();
        narration.setSource(source);
        narration.setNarrator(narrator);
        narration.setContent("test narration content, bla bla bla.");
        narrationRepo.save(narration);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String view() {
        return "/index";
    }
}
