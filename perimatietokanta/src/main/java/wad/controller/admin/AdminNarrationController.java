package wad.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Narration;
import wad.repository.BookRepository;
import wad.repository.NarrationRepository;
import wad.repository.NarratorRepository;
import wad.repository.ThemeRepository;

@Controller
@RequestMapping(value = "admin")
public class AdminNarrationController {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private NarrationRepository narrationRepo;

    @Autowired
    private NarratorRepository narratorRepo;

    @Autowired
    private ThemeRepository themeRepo;

    @RequestMapping(value = "narration", method = RequestMethod.POST)
    public String createNarration(@RequestParam String content,
            @RequestParam Long theme, @RequestParam Long narrator,
            @RequestParam Long book) {

        Narration narration = new Narration();
        narration.setBook(bookRepo.findOne(book));
        narration.setContent(content);
        narration.setNarrator(narratorRepo.findOne(narrator));
        narration.setTheme(themeRepo.findOne(theme));
        narrationRepo.save(narration);

        return "redirect:/index";
    }

    @RequestMapping(value = "narration/{id}", method = RequestMethod.DELETE)
    public String deleteNarration(@PathVariable Long id) {
        bookRepo.delete(id);
        return "redirect:/index";
    }

    @RequestMapping(value = "editnarration/{id}", method = RequestMethod.GET)
    public String viewNarrationEditor(@PathVariable Long id, Model model) {
        model.addAttribute("narration", narrationRepo.findOne(id));
        return "editnarration";
    }

    @RequestMapping(value = "editnarration/{id}", method = RequestMethod.POST)
    public String editNarration(@PathVariable Long id,
            @RequestParam String content, @RequestParam Long theme,
            @RequestParam Long narrator, @RequestParam Long book) {

        Narration narration = narrationRepo.findOne(id);
        narration.setBook(bookRepo.findOne(book));
        narration.setContent(content);
        narration.setNarrator(narratorRepo.findOne(narrator));
        narration.setTheme(themeRepo.findOne(theme));
        narrationRepo.save(narration);

        return "redirect:/index";
    }
}