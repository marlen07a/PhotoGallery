package com.example.photogallery.controller;

import com.example.photogallery.model.Image;
import com.example.photogallery.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GalleryController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/gallery")
    public String gallery(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("images", imageService.searchImages(search));
        model.addAttribute("aiImages", imageService.getAiImages());
        return "gallery";
    }

    @PostMapping("/ai/generate")
    public String generateAiImage(@RequestParam("prompt") String prompt, Model model) {
        imageService.generateAiImage(prompt);
        return "redirect:/gallery";
    }

    @PostMapping("/ai/like/{id}")
    public String likeAiImage(@PathVariable("id") Long id) {
        imageService.likeAiImage(id);
        return "redirect:/gallery";
    }

    @PostMapping("/ai/comment/{id}")
    public String addComment(@PathVariable("id") Long id, @RequestParam("comment") String comment) {
        imageService.addCommentToAiImage(id, comment);
        return "redirect:/gallery";
    }
}