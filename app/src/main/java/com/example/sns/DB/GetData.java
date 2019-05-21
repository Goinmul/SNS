package com.example.sns.DB;

import android.util.Log;

import com.example.sns.Model.Comment;
import com.example.sns.Model.Post;
import com.example.sns.Model.Subject;
import com.example.sns.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetData {
    private String phpType[] = {
            "http://samuel1226.dothome.co.kr/project/user.php",
            "http://samuel1226.dothome.co.kr/project/subject.php",
            "http://samuel1226.dothome.co.kr/project/post.php",
            "http://samuel1226.dothome.co.kr/project/comment.php"
    };

    public GetData() {    }

    public void resultUser(ArrayList<User> userset){

        URLConnector task = new URLConnector(phpType[0]);

        task.start();

        try {
            task.join();
            Log.d("test", "tryuser");
        } catch(InterruptedException e) {
            Log.d("test", ""+e);
        }

        String result = task.getResult();

        try {
            JSONArray jarray = new JSONArray(result);   // JSONArray 생성
            for(int i=0; i < jarray.length(); i++){
                User user = new User();
                JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                user.setIndex(jObject.getInt("index"));
                user.setUser_name(jObject.getString("user_name"));
                user.setUser_id(jObject.getString("user_id"));
                user.setUser_pw(jObject.getString("user_pw"));
                user.setUser_num(jObject.getInt("user_num"));

                userset.add(user);
            }
        } catch (JSONException e) {
            Log.d("test", ""+e);
            e.printStackTrace();
        }
    }

    public void resultSubject(ArrayList<Subject> subjectset){

        URLConnector task = new URLConnector(phpType[1]);

        task.start();

        try {
            task.join();
            Log.d("test", "trysub");
        } catch(InterruptedException e) {
            Log.d("test", ""+e);
        }

        String result = task.getResult();

        try {
            JSONArray jarray = new JSONArray(result);   // JSONArray 생성
            for(int i=0; i < jarray.length(); i++){
                Subject subject = new Subject();
                JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                subject.setIndex(jObject.getInt("index"));
                subject.setGrade(jObject.getString("grade"));
                subject.setSubject_name(jObject.getString("subject_name"));

                subjectset.add(subject);
            }
        } catch (JSONException e) {
            Log.d("test", ""+e);
            e.printStackTrace();
        }
    }

    public void resultPost(ArrayList<Post> postset){

        URLConnector task = new URLConnector(phpType[2]);

        task.start();

        try {
            task.join();
            Log.d("test", "try");
        } catch(InterruptedException e) {
            Log.d("test", ""+e);
        }

        String result = task.getResult();

        try {
            JSONArray jarray = new JSONArray(result);   // JSONArray 생성
            for(int i=0; i < jarray.length(); i++){
                Post post = new Post();
                JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                post.setIndex(jObject.getInt("index"));
                post.setSubject_name(jObject.getString("subject_name"));
                post.setUser_id(jObject.getString("user_id"));
                post.setTitle(jObject.getString("title"));
                post.setContent(jObject.getString("content"));
                post.setEdit_date(jObject.getString("edit_date"));
                post.setLike_count(jObject.getInt("like_count"));
                post.setPoint(jObject.getInt("point"));
                post.setPoint_sum(jObject.getInt("point_sum"));
                post.setPoint_count(jObject.getInt("point_count"));
                post.setView_count(jObject.getInt("view_count"));

                postset.add(post);
            }
        } catch (JSONException e) {
            Log.d("test", ""+e);
            e.printStackTrace();
        }
    }

    public void resultComment(ArrayList<Comment> commentset){

        URLConnector task = new URLConnector(phpType[3]);

        task.start();

        try {
            task.join();
            Log.d("test", "try");
        } catch(InterruptedException e) {
            Log.d("test", ""+e);
        }

        String result = task.getResult();

        try {
            JSONArray jarray = new JSONArray(result);   // JSONArray 생성
            for(int i=0; i < jarray.length(); i++){
                Comment comment = new Comment();
                JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                comment.setIndex(jObject.getInt("index"));
                comment.setPost_index(jObject.getInt("post_index"));
                comment.setUser_id(jObject.getString("user_id"));
                comment.setContent(jObject.getString("content"));
                comment.setEdit_date(jObject.getString("edit_date"));
                comment.setLike_count(jObject.getInt("like_count"));

                commentset.add(comment);
            }
        } catch (JSONException e) {
            Log.d("test", ""+e);
            e.printStackTrace();
        }
    }
}
