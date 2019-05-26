package com.example.sns.Post;

public class Dictionary {

    private String title;
    private String id;
    private String starpoint;

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getid() {
        return id;
    }//english -> id

    public void setid(String id) {
        id = id;
    }

    public String getstarpoint() {
        return starpoint;
    }

    public void setstarpoint(String starpoint) {
        starpoint = starpoint;
    }
    public Dictionary(String title , String id, String starpoint) {
        this.title = title;
        this.id = id;
        this.starpoint = starpoint;
    }
}