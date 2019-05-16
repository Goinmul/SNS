package com.example.sns.Model;

public class Post {
    private int index;
    private String subject_name;
    private String user_id;
    private String title;
    private String content;
    private String edit_date;
    private int like_count;
    private int point;
    private int point_sum;
    private int point_count;
    private int view_count;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(String edit_date) {
        this.edit_date = edit_date;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint_sum() {
        return point_sum;
    }

    public void setPoint_sum(int point_sum) {
        this.point_sum = point_sum;
    }

    public int getPoint_count() {
        return point_count;
    }

    public void setPoint_count(int point_count) {
        this.point_count = point_count;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }
}
