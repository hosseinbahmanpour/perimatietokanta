package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.repository.BookRepository;

@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookRepository bookRepo;
    
    @RequestMapping(method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "books";
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getBook(@PathVariable Long id, Model model) {
        model.addAttribute("narrations", bookRepo.findOne(id).getNarrations());
        return "narrations";
    }
}
