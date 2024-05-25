package com.utp.webintegrado.web.controller;

import com.utp.webintegrado.ollama.OllamaRequest;
import com.utp.webintegrado.ollama.OllamaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ollama/")
public class OllamaController {

    private final OllamaService ollamaService;

    public OllamaController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping
    public String generateSql(@RequestBody OllamaRequest request) {
        return ollamaService.generateExplanation(request);
    }
}
