package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Narration;
import wad.domain.Narrator;
import wad.domain.Theme;
import wad.repository.BookRepository;
import wad.repository.NarrationRepository;
import wad.repository.NarratorRepository;
import wad.repository.ThemeRepository;

@Controller
@RequestMapping(value = "/admin")
public class AdminDefaultController {

    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private NarrationRepository narrationRepo;
    @Autowired
    private NarratorRepository narratorRepo;
    @Autowired
    private ThemeRepository themeRepo;



    @RequestMapping(method = RequestMethod.GET)
    public String view(Model model) {
        
        model.addAttribute("books", bookRepo.findAll());
        model.addAttribute("narrators", narratorRepo.findAll());
        model.addAttribute("themes", themeRepo.findAll());
        
        return "admin";
    }
}
