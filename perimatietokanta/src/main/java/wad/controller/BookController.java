package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Source;
import wad.repository.SourceRepository;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private SourceRepository bookRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "books";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getBook(Model model, @PathVariable Long id) {
        model.addAttribute("nby", bookRepo.findOne(id));
        return "narratedby";
    }

    @Secured("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {
        bookRepo.delete(id);
        return "redirect:/books";
    }

    @Secured("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public String postBook(@RequestBody Source book) {
        bookRepo.save(book);
        return "redirect:/books";
    }
}
