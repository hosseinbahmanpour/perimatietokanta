package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NarratorController {
    
    @Autowired
    private SourceRepository bookRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "books";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getBook(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookRepo.findOne(id));
        return "book";
    }
    
}
