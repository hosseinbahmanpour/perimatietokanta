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
public class SourceController {

    @Autowired
    private SourceRepository sourceRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getSources(Model model) {
        model.addAttribute("sources", sourceRepository.findAll());
        return "sources";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getBook(Model model, @PathVariable Long id) {
        model.addAttribute("source", sourceRepository.findOne(id));
        return "book";
    }

    @Secured("hasRole('ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {
        sourceRepository.delete(id);
        return "redirect:/books";
    }

    @Secured("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public String postBook(@RequestBody Source book) {
        sourceRepository.save(book);
        return "redirect:/books";
    }
}
