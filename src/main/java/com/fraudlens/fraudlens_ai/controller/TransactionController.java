package com.fraudlens.fraudlens_ai.controller;

import com.fraudlens.fraudlens_ai.model.Transaction;
import com.fraudlens.fraudlens_ai.repository.TransactionRepository;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("transactions", repository.findAll());
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please choose a CSV file.");
            model.addAttribute("transactions", repository.findAll());
            return "upload";
        }

        List<Transaction> list = new ArrayList<>();
        int skipped = 0;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String line = reader.readLine(); // header row skip
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] p = line.split(",", -1);
                try {
                    Transaction t = new Transaction();
                    t.setSender(p[0].trim());
                    t.setBeneficiary(p[1].trim());
                    t.setAmount(Double.parseDouble(p[2].trim()));
                    t.setTxnTime(LocalDateTime.parse(p[3].trim()));
                    t.setDevice(p[4].trim());
                    t.setLocation(p[5].trim());
                    list.add(t);
                } catch (Exception e) {
                    skipped++;
                }
            }
        } catch (Exception e) {
            model.addAttribute("message", "Could not read file: " + e.getMessage());
            model.addAttribute("transactions", repository.findAll());
            return "upload";
        }

        repository.saveAll(list);
        model.addAttribute("message", "Saved " + list.size() + " transactions. Skipped " + skipped + " bad rows.");
        model.addAttribute("transactions", repository.findAll());
        return "upload";
    }
}