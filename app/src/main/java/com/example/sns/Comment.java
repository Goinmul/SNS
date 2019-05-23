package com.example.sns;

/**
 * Created by JKPC on 2019-05-14.
 */

public class Comment {
    private String name ;
    private String contents ;
    private String like = "like" ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Comment(String name, String contents) {
        this.name = name;
        this.contents = contents;
        this.like = "like" ;
    }
}
