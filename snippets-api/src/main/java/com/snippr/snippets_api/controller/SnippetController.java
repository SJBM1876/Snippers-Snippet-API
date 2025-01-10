package com.snippr.snippets_api.controller;

import com.snippr.snippets_api.model.Snippet;
import com.snippr.snippets_api.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snippets")
public class SnippetController {

    @Autowired
    private SnippetService snippetService;

    @GetMapping
    public List<Snippet> getAllSnippets(@RequestParam(required = false) String lang) {
        if (lang != null) {
            return snippetService.getSnippetsByLanguage(lang);
        }
        return snippetService.getAllSnippets();
    }

    @GetMapping("/{id}")
    public Snippet getSnippetById(@PathVariable int id) {
        return snippetService.getSnippetById(id);
    }

    @PostMapping
    public Snippet createSnippet(@RequestBody Snippet snippet) {
        return snippetService.createSnippet(snippet);
    }
}
