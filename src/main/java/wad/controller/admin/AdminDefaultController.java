package wad.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.repository.BookRepository;
import wad.repository.NarratorRepository;
import wad.repository.ThemeRepository;

@Controller
@RequestMapping(value = "/admin")
public class AdminDefaultController {

    @Autowired
    private BookRepository bookRepo;
    
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
