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
import java.util.Locale;

@Controller
@RequestMapping("/admin")
public class AdminController {
    Repository<JobForm> jobRepository;

    @Autowired
    public AdminController(PostgresJobRepository repository) {
        jobRepository = repository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("adminJobs", jobRepository.findAll());
        return "admin";
    }

    @GetMapping("/{id}")
    public String getAdminJobPage(Model model, @PathVariable(value = "id") Integer id) {
        var job = jobRepository.findById(id);
        if(job.isPresent()) {
            model.addAttribute("adminJob", job.get());
            return "adminJob";
        } else {
            return "404";
        }
    }

    @RequestMapping(params="old", method=RequestMethod.GET)
    public String getOldest(Model model) {
        model.addAttribute("adminJobs", jobRepository.oldest());
        return "admin";
    }

    @RequestMapping(params="date", method=RequestMethod.GET)
    public String getDate(Model model, @RequestParam("date") String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date range = dateFormat.parse(date);
            model.addAttribute("adminJobs", jobRepository.findByDate(range));
            model.addAttribute("date", range);
            return "admin";
        } catch (ParseException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error parsing date!");
            return "admin";
        }
    }
}
