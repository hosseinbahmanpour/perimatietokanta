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
import wad.domain.Theme;
import wad.repository.BookRepository;
import wad.repository.NarrationRepository;
import wad.repository.NarratorRepository;
import wad.repository.ThemeRepository;

@Controller
@RequestMapping(value = "admin")
public class AdminThemeController {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private NarrationRepository narrationRepo;

    @Autowired
    private NarratorRepository narratorRepo;

    @Autowired
    private ThemeRepository themeRepo;

    @RequestMapping(value = "theme", method = RequestMethod.POST)
    public String createTheme(@RequestParam String teema) {

        Theme theme = new Theme();
        theme.setTheme(teema);
        themeRepo.save(theme);

        return "redirect:/themes";
    }

    @RequestMapping(value = "theme/{id}", method = RequestMethod.DELETE)
    public String deleteTheme(@PathVariable Long id) {
        Collection<Narration> narrations = narrationRepo.findByBook(bookRepo.findOne(id));

        narrations.stream().forEach((n) -> {
            bookRepo.findOne(n.getNarrator().getId()).getNarrations().remove(n);
            narratorRepo.findOne(n.getNarrator().getId()).getNarrations().remove(n);
            narrationRepo.delete(n);
        });

        themeRepo.delete(id);
        return "redirect:/themes";
    }

    @RequestMapping(value = "edittheme/{id}", method = RequestMethod.GET)
    public String viewThemeEditor(@PathVariable Long id, Model model) {
        model.addAttribute("theme", themeRepo.findOne(id));
        return "edittheme";
    }

    @RequestMapping(value = "edittheme/{id}", method = RequestMethod.POST)
    public String editTheme(@PathVariable Long id, @RequestParam String theme, Model model) {

        Theme teema = themeRepo.findOne(id);
        teema.setTheme(theme);
        themeRepo.save(teema);

        return "redirect:/themes";
    }
}
