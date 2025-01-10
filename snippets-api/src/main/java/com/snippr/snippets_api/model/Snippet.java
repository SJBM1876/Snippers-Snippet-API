package com.snippr.snippets_api.model;

public class Snippet {
    private int id;
    private String language;
    private String code;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Constructor
    public Snippet(int id, String language, String code) {
        this.id = id;
        this.language = language;
        this.code = code;
    }
}
