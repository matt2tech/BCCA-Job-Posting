package com.bcca.app.forms;

import java.util.Date;

public class CommentForm {
    private Integer id;
    private String name;
    private String comment;
    private Date date;
    private Integer postId;

    public CommentForm(){

    }

    public CommentForm(Integer id, String name, String comment, Date date, Integer postId) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.date = date;
        this.postId = postId;
    }

    public CommentForm(String name, String comment, Date date, Integer postId) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
