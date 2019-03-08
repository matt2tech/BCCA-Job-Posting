package com.bcca.app.controllers;

import com.bcca.app.forms.JobForm;
import com.bcca.app.repositories.PostgresJobRepository;
import com.bcca.app.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/")
public class HomeController {
    Repository<JobForm> jobRepository;

    @Autowired
    public HomeController(PostgresJobRepository repository) {
        jobRepository = repository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "home";
    }
}
