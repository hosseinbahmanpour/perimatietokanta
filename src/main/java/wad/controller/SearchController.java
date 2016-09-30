package wad.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Narration;
import wad.repository.NarrationRepository;

@Controller
@RequestMapping(value = "search")
public class SearchController {

    @Autowired
    private NarrationRepository narrationRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String view() {
        return "search";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("narrations", narrationRepo.findByContentContainingIgnoreCase(keyword));
        return "narrations";
    }
}
