package com.dfc.hangul;

import com.dfc.hangul.model.Event;
import com.dfc.hangul.service.EventService;
import com.dfc.hangul.service.GalleryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private final EventService eventService;
    private final GalleryService galleryService;

    public HomeController(EventService eventService, GalleryService galleryService) {
        this.eventService = eventService;
        this.galleryService = galleryService;
    }

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

        // Ensure non-null model attributes (prevents Thymeleaf 500s if a service returns null)
        List<Event> events = Optional.ofNullable(eventService.list()).orElseGet(List::of);
        List<Map<String,String>> gallery = Optional.ofNullable(galleryService.tasteOfKorea2025()).orElseGet(List::of);

        model.addAttribute("events", events);
        model.addAttribute("tokGallery", gallery);
        model.addAttribute("tokTitle", "Taste of Korea — Event Highlights");
        model.addAttribute("tokSubtitle", "Thanks to everyone who joined! Here are a few moments from the night.");

        log.info("GET /events -> events={}, gallery={}", events.size(), gallery.size());
        return "events";
    }
}
