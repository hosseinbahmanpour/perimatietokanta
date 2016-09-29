package wad.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Book;
import wad.repository.BookRepository;

@Controller
@RequestMapping(value = "admin")
public class AdminBookController {

    @Autowired
    private BookRepository bookRepo;

    @RequestMapping(value = "book", method = RequestMethod.POST)
    public String createBook(@RequestParam String title, 
            @RequestParam String author) {
        
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookRepo.save(book);
        
        return "redirect:/books";
    }

    @RequestMapping(value = "book/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable Long id) {        
        bookRepo.delete(id);        
        return "redirect:/books";
    }

    @RequestMapping(value = "editbook/{id}", method = RequestMethod.GET)
    public String viewBookEditor(@PathVariable Long id, Model model) {        
        model.addAttribute("book", bookRepo.findOne(id));        
        return "editbook";
    }

    @RequestMapping(value = "editbook/{id}", method = RequestMethod.POST)
    public String editBook(@PathVariable Long id, @RequestParam String title, 
            @RequestParam String author, Model model) {
        
        Book book = bookRepo.findOne(id);
        book.setAuthor(author);
        book.setTitle(title);
        bookRepo.save(book);
        
        return "redirect:/books";
    }
}
