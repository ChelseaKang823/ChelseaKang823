package com.test.model;

public class Articles {
    private Integer id;

    private String title;

    private String body;

    public Articles(Integer id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Articles() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}