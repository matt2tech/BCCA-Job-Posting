package com.bcca.app.forms;

import java.util.Date;

public class CommentForm {
    private Integer id;
    private String comment;
    private Date date;
    private Integer postId;

    public CommentForm(){

    }

    public CommentForm(Integer id, String comment, Date date, Integer postId) {
        this.id = id;
        this.comment = comment;
        this.date = date;
        this.postId = postId;
    }

    public CommentForm(String comment, Date date, Integer postId) {
        this.comment = comment;
        this.date = date;
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Boolean isValid() {
        return comment != null;
    }
}
