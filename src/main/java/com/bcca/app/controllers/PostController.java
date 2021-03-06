package com.bcca.app.controllers;

import com.bcca.app.forms.JobForm;
import com.bcca.app.repositories.PostgresJobRepository;
import com.bcca.app.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
    Repository<JobForm> jobRepository;

    @Autowired
    public PostController(PostgresJobRepository repository) {
        jobRepository = repository;
    }

    @GetMapping
    public String index() {
        return "post";
    }

    @PostMapping
    public String postJob(JobForm job, Model model) {
        if (job.isValid()) {
            jobRepository.save(job);
            return "redirect:/";
        } else {
            model.addAttribute("failure", "An error has occurred. Please try again.");
            return "post";
        }
    }
}
