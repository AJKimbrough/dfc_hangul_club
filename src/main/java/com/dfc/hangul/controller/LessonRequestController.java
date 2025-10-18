package com.dfc.hangul.controller;

import com.dfc.hangul.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LessonRequestController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/lesson-request")
    public String handleLessonRequest(
            @RequestParam("name") String name,
            @RequestParam("teacher") String teacher,
            @RequestParam("time") String time,
            Model model) {

        // Log the incoming data
        System.out.println("📬 Lesson Request -> " + name + " | " + teacher + " | " + time);

        // ✅ Send email using the correct method
        emailService.sendLessonRequestEmail(name, teacher, time);

        // Pass data to confirmation page
        model.addAttribute("name", name);
        model.addAttribute("teacher", teacher);
        model.addAttribute("time", time);

        // Render confirmation view
        return "lesson-request-success";
    }
}
