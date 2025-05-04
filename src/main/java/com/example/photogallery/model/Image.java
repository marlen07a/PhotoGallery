package com.example.photogallery.model;

import java.util.ArrayList;
import java.util.List;

public class Image {
    private Long id;
    private String url;
    private String title;
    private String prompt;
    private int likes;
    private List<String> comments;

    public Image(Long id, String url, String title, String prompt) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.prompt = prompt;
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getPrompt() { return prompt; }
    public void setPrompt(String prompt) { this.prompt = prompt; }
    public int getLikes() { return likes; }
    public void setLikes(int likes) { this.likes = likes; }
    public List<String> getComments() { return comments; }
    public void setComments(List<String> comments) { this.comments = comments; }
    public void addComment(String comment) { this.comments.add(comment); }
}
