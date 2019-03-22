package com.bcca.app.controllers;

import com.bcca.app.forms.CommentForm;
import com.bcca.app.forms.JobForm;
import com.bcca.app.repositories.PostgresJobRepository;
import com.bcca.app.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class AdminJobController {
    Repository<JobForm> jobRepository;

    @Autowired
    public AdminJobController(PostgresJobRepository repository) {
        jobRepository = repository;
    }

    @PostMapping("/admin/{id}/delete")
    public String deletePost(@PathVariable(value="id") String id) {
        jobRepository.deletePost(Integer.parseInt(id));
        return "redirect:/admin";
    }

    @PostMapping("/admin/{id}")
    public String postCom(CommentForm com, @PathVariable(value = "id") Integer id) {
        CommentForm comment = new CommentForm(com.getName(), com.getComment(), new Date(), id);
        if (comment.isValid()) {
            jobRepository.saveComment(comment);
            return "redirect:/admin/" + id;
        } else {
            System.out.println("Mission failed. We'll get em next time.");
            return "redirect:/admin/" + id;
        }
    }

    @PostMapping("/admin/{postId}/{id}/delete")
    public String deleteComment(@PathVariable(value = "id") String id, @PathVariable(value="postId") String postId){
        jobRepository.deleteComment(Integer.parseInt(id));
        return "redirect:/admin/" + postId;
    }
}
