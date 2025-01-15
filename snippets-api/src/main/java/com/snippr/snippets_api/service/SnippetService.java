package com.snippr.snippets_api.service;

import com.snippr.snippets_api.model.Snippet;
import com.snippr.snippets_api.util.EncryptionUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SnippetService {

    private List<Snippet> snippets = new ArrayList<>();

    public SnippetService() {
        try {
            // Seed data
            snippets.add(new Snippet(1, "Python", "print('Hello, World!')"));
            snippets.add(new Snippet(2, "Python", "def add(a, b):\n    return a + b"));
            snippets.add(new Snippet(3, "Python", "class Circle:\n    def __init__(self, radius):\n        self.radius = radius\n\n    def area(self):\n        return 3.14 * self.radius ** 2"));
            snippets.add(new Snippet(4, "JavaScript", "console.log('Hello, World!');"));
            snippets.add(new Snippet(5, "JavaScript", "function multiply(a, b) {\n    return a * b;\n}"));
            snippets.add(new Snippet(6, "JavaScript", "const square = num => num * num;"));
            snippets.add(new Snippet(7, "Java", "public class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello, World!\");\n    }\n}"));
            snippets.add(new Snippet(8, "Java", "public class Rectangle {\n    private int width;\n    private int height;\n\n    public Rectangle(int width, int height) {\n        this.width = width;\n        this.height = height;\n    }\n\n    public int getArea() {\n        return width * height;\n    }\n}"));
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting seed data", e);
        }
    }

    public List<Snippet> getAllSnippets() {
        // Decrypt each snippet before returning.
        return snippets.stream()
                .map(this::decryptSnippet)
                .collect(Collectors.toList());
    }

    public Snippet getSnippetById(int id) {
        // Find the snippet by ID and decrypt it.
        return decryptSnippet(
                snippets.stream()
                .filter(snippet -> snippet.getId() == id)
                .findFirst()
                .orElse(null)
        );
    }

    public List<Snippet> getSnippetsByLanguage(String language) {
        // Decrypt snippets by language
        return snippets.stream()
                .filter(snippet -> snippet.getLanguage().equalsIgnoreCase(language))
                .map(this::decryptSnippet) // Ensure decryption
                .collect(Collectors.toList());
    }

    public Snippet createSnippet(Snippet snippet) {
        try {
            // Encrypt the snippet's code before saving
            snippet.setCode(EncryptionUtil.encrypt(snippet.getCode()));
            snippets.add(snippet);
            return snippet;
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting snippet", e);
        }
    }

    private Snippet decryptSnippet(Snippet snippet) {
        try {
            // Decrypt the snippet's code
            if (snippet != null) {
                snippet.setCode(EncryptionUtil.decrypt(snippet.getCode()));
            }
            return snippet;
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting snippet", e);
        }
    }
}
