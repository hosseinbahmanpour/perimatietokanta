package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Theme;
import wad.repository.ThemeRepository;

@Controller
@RequestMapping(value = "admin")
public class AdminThemeController {

    @Autowired
    private ThemeRepository themeRepo;

    @RequestMapping(value = "theme", method = RequestMethod.POST)
    public String createTheme(@RequestParam String teema) {
        
        Theme theme = new Theme();
        theme.setTheme(teema);
        themeRepo.save(theme);
        
        return "redirect:/themes";
    }
}
