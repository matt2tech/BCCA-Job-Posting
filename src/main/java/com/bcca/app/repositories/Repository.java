package com.bcca.app.repositories;

import com.bcca.app.forms.CommentForm;
import com.bcca.app.forms.JobForm;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<JobForm> findAll();

    List<CommentForm> findAllComments(Integer id);

    List<JobForm> oldest();

    List<JobForm> findByDate(Date date);

    Optional<JobForm> findById(Integer id);

    void deletePost(Integer id);

    void save(JobForm job);

    void saveComment(CommentForm com);

    void deleteComment(Integer id);

}
