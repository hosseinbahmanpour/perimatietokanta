package wad.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.domain.Narrator;
import wad.repository.NarratorRepository;

@Controller
@RequestMapping(value = "admin")
public class AdminNarratorController {

    @Autowired
    private NarratorRepository narratorRepo;

    @RequestMapping(value = "narrator", method = RequestMethod.POST)
    public String createNarrator(@RequestParam String name) {
        
        Narrator narrator = new Narrator();
        narrator.setName(name);
        narratorRepo.save(narrator);
        
        return "redirect:/narrators";
    }

}
