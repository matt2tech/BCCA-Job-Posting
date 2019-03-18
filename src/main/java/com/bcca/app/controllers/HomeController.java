package com.bcca.app.controllers;

import com.bcca.app.forms.JobForm;
import com.bcca.app.repositories.PostgresJobRepository;
import com.bcca.app.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Date;

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

    @GetMapping("/{id}")
    public String getJobPage(Model model, @PathVariable(value = "id") Integer id) {
        var job = jobRepository.findById(id);
        if(job.isPresent()) {
            model.addAttribute("job", job.get());
            return "job";
        } else {
            return "404";
        }
    }

    @RequestMapping(params="old", method=RequestMethod.GET)
    public String getOldest(Model model) {
        model.addAttribute("jobs", jobRepository.oldest());
        return "home";
    }

    @RequestMapping(params="date", method=RequestMethod.GET)
    public String getDate(Model model, @RequestParam("date") String date) {
        model.addAttribute("jobs", jobRepository.findByDate(date));
        return "home";
    }
}
