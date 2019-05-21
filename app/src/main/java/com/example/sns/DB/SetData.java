package com.example.sns.DB;

import android.util.Log;

public class SetData {
    private String phpType[] = {
            "http://samuel1226.dothome.co.kr/project/signup.php",
            "http://samuel1226.dothome.co.kr/project/writepost.php",
            "http://samuel1226.dothome.co.kr/project/editpost.php",
            "http://samuel1226.dothome.co.kr/project/deletepost.php",
            "http://samuel1226.dothome.co.kr/project/likepost.php",
            "http://samuel1226.dothome.co.kr/project/pointpost.php",
            "http://samuel1226.dothome.co.kr/project/viewpost.php",
            "http://samuel1226.dothome.co.kr/project/writecomment.php",
            "http://samuel1226.dothome.co.kr/project/editcomment.php",
            "http://samuel1226.dothome.co.kr/project/deletecomment.php",
            "http://samuel1226.dothome.co.kr/project/likecomment.php"
    };

    public SetData() {    }

    public void signUp(String id, String pass, String name, int num) {

        URLConnector task = new URLConnector(phpType[0] + "?id=" + id + "&pass=" + pass + "&name=" + name + "&num=" + num);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try signup");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }

    public void writePost(String subject, String id, String title, String content) {

        URLConnector task = new URLConnector(phpType[1] + "?subject=" + subject + "&id=" + id + "&title=" + title + "&content=" + content);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try write post");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }

    public void editPost(String subject, String title, String content, int index) {

        URLConnector task = new URLConnector(phpType[2] + "?subject=" + subject + "&title=" + title + "&content=" + content + "&index=" + index);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try edit post");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }

    public void deletePost(int index) {

        URLConnector task = new URLConnector(phpType[3] + "?index=" + index);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try delete post");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }

    public void likePost(int index) {

        URLConnector task = new URLConnector(phpType[4] + "?index=" + index);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try like post");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }

    public void pointPost(double point, double point_sum, int point_count, int index) {
        double temp_sum = point_sum + point;
        int temp_count = point_count + 1;
        double temp_point = temp_sum / (temp_count);

        Log.d("Set test", "point sum " + temp_sum);
        Log.d("Set test", "point " + temp_point);
        Log.d("Set test", "point count " + temp_count);

        URLConnector task = new URLConnector(phpType[5] + "?point=" + temp_point + "&point_sum=" + temp_sum + "&point_count=" + temp_count + "&index=" + index);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try point post");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }

    public void viewPost(int index) {

        URLConnector task = new URLConnector(phpType[6] + "?index=" + index);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try view");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }

    public void writeComment(int post, String id, String content) {

        URLConnector task = new URLConnector(phpType[7] + "?post=" + post + "&id=" + id + "&content=" + content);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try write comment");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }

    public void editComment(String content, int index) {

        URLConnector task = new URLConnector(phpType[8] + "?content=" + content + "&index=" + index);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try edit comment");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }

    public void deleteComment(int index) {

        URLConnector task = new URLConnector(phpType[9] + "?index" + index);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try delete comment");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }

    public void likeComment(int index) {

        URLConnector task = new URLConnector(phpType[10] + "?index=" + index);

        task.start();

        try {
            task.join();
            Log.d("Set test", "try like comment");
        } catch(InterruptedException e) {
            Log.d("Set test", ""+e);
        }

    }
}
