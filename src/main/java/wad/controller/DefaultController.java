package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(method = RequestMethod.GET)
    public String view() {
        return "index";
    }
}
