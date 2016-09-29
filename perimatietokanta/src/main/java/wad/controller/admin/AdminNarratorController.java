package wad.controller.admin;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Narration;
import wad.domain.Narrator;
import wad.repository.BookRepository;
import wad.repository.NarrationRepository;
import wad.repository.NarratorRepository;
import wad.repository.ThemeRepository;

@Controller
@RequestMapping(value = "admin")
public class AdminNarratorController {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private NarrationRepository narrationRepo;

    @Autowired
    private NarratorRepository narratorRepo;

    @Autowired
    private ThemeRepository themeRepo;

    @RequestMapping(value = "narrator", method = RequestMethod.POST)
    public String createNarrator(@RequestParam String name) {

        Narrator narrator = new Narrator();
        narrator.setName(name);
        narratorRepo.save(narrator);

        return "redirect:/narrators";
    }

    @RequestMapping(value = "narrator/{id}", method = RequestMethod.DELETE)
    public String deleteNarrator(@PathVariable Long id) {

        Collection<Narration> narrations = narrationRepo.findByNarrator(narratorRepo.findOne(id));

        narrations.stream().forEach((n) -> {
            bookRepo.findOne(n.getNarrator().getId()).getNarrations().remove(n);
            themeRepo.findOne(n.getNarrator().getId()).getNarrations().remove(n);
            narrationRepo.delete(n);
        });
        
        narratorRepo.delete(id);
        return "redirect:/narrators";
    }

    @RequestMapping(value = "editnarrator/{id}", method = RequestMethod.GET)
    public String viewNarratorEditor(@PathVariable Long id, Model model) {
        model.addAttribute("narrator", narratorRepo.findOne(id));
        return "editnarrator";
    }

    @RequestMapping(value = "editnarrator/{id}", method = RequestMethod.POST)
    public String editNarrator(@PathVariable Long id, @RequestParam String name, Model model) {

        Narrator narrator = narratorRepo.findOne(id);
        narrator.setName(name);
        narratorRepo.save(narrator);

        return "redirect:/narrators";
    }
}
