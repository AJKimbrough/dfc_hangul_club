package com.dfc.hangul;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("clubName", "DFC Hangul");
        model.addAttribute("tagline", "Korean language & culture at UTD");
        return "index"; // resolves to src/main/resources/templates/index.html
    }
}
