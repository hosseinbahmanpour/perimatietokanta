package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.repository.BookRepository;

@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private BookRepository bookRepo;
    
    @RequestMapping(method = RequestMethod.POST)
    public String view(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "/books";
    }
}
