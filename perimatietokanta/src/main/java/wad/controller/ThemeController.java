package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.repository.ThemeRepository;

@Controller
@RequestMapping("/themes")
public class ThemeController {

    @Autowired
    private ThemeRepository themeRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String listThemes(Model model) {
        model.addAttribute("themes", themeRepo.findAll());
        return "themes";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getTheme(@PathVariable Long id, Model model) {
        model.addAttribute("narrations", themeRepo.findOne(id).getNarrations());
        return "narrations";
    }
}
