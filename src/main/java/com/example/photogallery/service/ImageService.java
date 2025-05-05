package com.example.photogallery.service;

import com.example.photogallery.model.Image;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService {
    private List<Image> images = new ArrayList<>();
    private List<Image> aiImages = new ArrayList<>();

    public ImageService() {
        images.add(new Image(1L, "https://via.placeholder.com/200", "Nature", null));
        images.add(new Image(2L, "https://via.placeholder.com/201", "City", null));
    }

    public List<Image> getAllImages() {
        return images;
    }

    public List<Image> searchImages(String query) {
        if (query == null || query.isEmpty()) {
            return images;
        }
        return images.stream()
                .filter(img -> img.getTitle().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Image> getAiImages() {
        return aiImages;
    }

    public Image generateAiImage(String prompt) {
        Image image = new Image(System.currentTimeMillis(), "https://via.placeholder.com/200?text=" + prompt, prompt, prompt);
        aiImages.add(image);
        return image;
    }

    public void likeAiImage(Long id) {
        aiImages.stream()
                .filter(img -> img.getId().equals(id))
                .findFirst()
                .ifPresent(img -> img.setLikes(img.getLikes() + 1));
    }

    public void addCommentToAiImage(Long id, String comment) {
        aiImages.stream()
                .filter(img -> img.getId().equals(id))
                .findFirst()
                .ifPresent(img -> img.addComment(comment));
    }
}
