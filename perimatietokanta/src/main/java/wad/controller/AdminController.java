package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Book;
import wad.domain.Narration;
import wad.domain.Narrator;
import wad.domain.Theme;
import wad.repository.BookRepository;
import wad.repository.NarrationRepository;
import wad.repository.NarratorRepository;
import wad.repository.ThemeRepository;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    
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
    
    @RequestMapping(value = "book", method = RequestMethod.POST)
    public String createBook(@RequestParam String title, @RequestParam String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookRepo.save(book);
        return "redirect:/admin";
    }
    
    @RequestMapping(value = "narration", method = RequestMethod.POST)
    public String createNarration(@RequestParam String content, @RequestParam String page,
            @RequestParam Long theme, @RequestParam Long narrator, @RequestParam Long book) {
        Narration narration = new Narration();
        narration.setBook(bookRepo.findOne(book));
        narration.setContent(content);
        narration.setNarrator(narratorRepo.findOne(narrator));
        narration.setPage(Integer.parseInt(page));
        narration.setTheme(themeRepo.findOne(theme));
        narrationRepo.save(narration);
        return "redirect:/admin";
    }
    
    @RequestMapping(value = "narrator", method = RequestMethod.POST)
    public String createNarrator(@RequestParam String name) {
        Narrator narrator = new Narrator();
        narrator.setName(name);
        narratorRepo.save(narrator);
        return "redirect:/admin";
    }
    
    @RequestMapping(value = "theme", method = RequestMethod.POST)
    public String createTheme(@RequestParam String teema) {
        Theme theme = new Theme();
        theme.setTheme(teema);
        themeRepo.save(theme);
        return "redirect:/admin";
    }
}
