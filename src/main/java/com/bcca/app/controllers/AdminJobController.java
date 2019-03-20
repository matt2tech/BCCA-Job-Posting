package com.bcca.app.controllers;

import com.bcca.app.forms.CommentForm;
import com.bcca.app.forms.JobForm;
import com.bcca.app.repositories.PostgresJobRepository;
import com.bcca.app.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminJobController {
    Repository<JobForm> jobRepository;

    @Autowired
    public AdminJobController(PostgresJobRepository repository) {
        jobRepository = repository;
    }

    @PostMapping("/admin/{id}/delete")
    public String deletePost(@PathVariable(value="id") String id) {
        System.out.println("CHECKPOINT 1 " + id);
        jobRepository.deletePost(Integer.parseInt(id));
        return "redirect:/admin";
    }


//    causing errors with static files

//    @PostMapping
//    public String postCom(CommentForm com) {
//        if (com.isValid()) {
//            jobRepository.saveComment(com);
//            return "adminJob";
//        } else {
//            return "adminJob";
//        }
//    }
}
