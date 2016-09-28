package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.repository.NarratorRepository;

@Controller
@RequestMapping("/narrators")
public class NarratorController {

    @Autowired
    private NarratorRepository narratorRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String listThemes(Model model) {
        model.addAttribute("narrators", narratorRepo.findAll());
        return "narrators";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getTheme(@PathVariable Long id, Model model) {
        model.addAttribute("narrations", narratorRepo.findOne(id).getNarrations());
        return "narrations";
    }
}
