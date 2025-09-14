package com.dfc.hangul.service;


import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class GalleryService {
    public List<Map<String,String>> tasteOfKorea2025(){
        // Place matching images in /static/img/taste-of-korea/
        // Update captions as you like.
    String base = "/image/";
    return List.of(
        Map.of("src", base + "1.JPEG", "alt", "Group photo at Taste of Korea"),
        Map.of("src", base + "2.JPEG", "alt", "Tteokbokki prep"),
        Map.of("src", base + "3.JPEG", "alt", "Calligraphy station"),
        Map.of("src", base + "4.JPEG", "alt", "K‑pop trivia winners"),
        Map.of("src", base + "5.JPEG", "alt", "Cultural games"),
        Map.of("src", base + "6.JPEG", "alt", "Performance stage"),
        Map.of("src", base + "7.JPEG", "alt", "Food tasting")
        );
    }
}