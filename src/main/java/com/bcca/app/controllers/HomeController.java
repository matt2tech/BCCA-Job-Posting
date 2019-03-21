package com.bcca.app.controllers;

import com.bcca.app.forms.JobForm;
import com.bcca.app.repositories.PostgresJobRepository;
import com.bcca.app.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        var com = jobRepository.findAllComments(id);
        if(job.isPresent()) {
            model.addAttribute("job", job.get());
            model.addAttribute("com", com);
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date range = dateFormat.parse(date);
            model.addAttribute("jobs", jobRepository.findByDate(range));
            model.addAttribute("date", range);
            return "home";
        } catch (ParseException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error parsing date!");
            return "home";
        }
    }
}
