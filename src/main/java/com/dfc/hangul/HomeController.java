package com.dfc.hangul;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Common attributes available to all pages
    private void populateCommon(Model model) {
        model.addAttribute("clubName", "DFC Hangul");
        model.addAttribute("tagline", "Korean language & culture at UTD");
    }

    @GetMapping("/")
    public String root(Model model) {
        return about(model); // show About page as landing page
    }

    @GetMapping("/about")
    public String about(Model model) {
        populateCommon(model);
        model.addAttribute("activePage", "about");
        model.addAttribute("pageTitle", "DFC Hangul — About");
        return "about";
    }

    @GetMapping("/officers")
    public String officers(Model model) {
        populateCommon(model);
        model.addAttribute("activePage", "officers");
        model.addAttribute("pageTitle", "DFC Hangul — Officers");
        return "officers";
    }

    @GetMapping("/lessons")
    public String lessons(Model model) {
        populateCommon(model);
        model.addAttribute("activePage", "lessons");
        model.addAttribute("pageTitle", "DFC Hangul — Language Lessons");
        return "lessons";
    }

    @GetMapping("/club")
    public String club(Model model) {
        populateCommon(model);
        model.addAttribute("activePage", "club");
        model.addAttribute("pageTitle", "DFC Hangul — Club");
        return "club";
    }

    @GetMapping("/events")
    public String events(Model model) {
        populateCommon(model);
        model.addAttribute("activePage", "events");
        model.addAttribute("pageTitle", "DFC Hangul — Events");
        return "events";
    }
}
