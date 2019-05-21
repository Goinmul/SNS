package com.example.sns.Model;

public class User {
    private int index;
    private String user_name;
    private String user_id;
    private String user_pw;
    private int user_num;

    public User() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) { this.user_name = user_name;  }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pw() {
        return user_pw;
    }

    public void setUser_pw(String user_pw) {
        this.user_pw = user_pw;
    }

    public int getUser_num() {
        return user_num;
    }

    public void setUser_num(int user_num) {
        this.user_num = user_num;
    }
}
