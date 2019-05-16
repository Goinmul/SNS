package com.example.sns.DB;

import android.util.Log;

import com.example.sns.Model.Comment;
import com.example.sns.Model.Post;
import com.example.sns.Model.Subject;
import com.example.sns.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetData {
    private String phpType[] = {
            "http://samuel1226.dothome.co.kr/project/user.php",
            "http://samuel1226.dothome.co.kr/project/subject.php",
            "http://samuel1226.dothome.co.kr/project/post.php",
            "http://samuel1226.dothome.co.kr/project/comment.php"
    };
    StringBuffer sb = new StringBuffer();

    public GetData() {
    }

    public void result(User user){

        Log.d("test", phpType[0]);

        URLConnector task = new URLConnector(phpType[0]);

        task.start();

        try {
            task.join();
            Log.d("test", "try");
        } catch(InterruptedException e) {
            Log.d("test", ""+e);
        }

        String result = task.getResult();

        Log.d("test", result);

        try {
            JSONArray jarray = new JSONArray(result);   // JSONArray 생성
            for(int i=0; i < jarray.length(); i++){
                JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                user.setIndex(jObject.getInt("index"));
                user.setUser_name(jObject.getString("user_name"));
                user.setUser_id(jObject.getString("user_id"));
                user.setUser_pw(jObject.getString("user_pw"));
                user.setUser_num(jObject.getInt("user_num"));

                sb.append( //test를 위한 용도
                        "\n" +
                                "인덱스:" + user.getIndex() +
                                "이름:" + user.getUser_name() +
                                "아이디:" + user.getUser_id() +
                                "비밀번호:" + user.getUser_pw() +
                                "학번:" + user.getUser_num()
                );
            }
            Log.d("test", sb.toString()); //test를 위한 용도

        } catch (JSONException e) {
            Log.d("test", ""+e);
            e.printStackTrace();
        }
    }

    public void result(Subject subject){

        Log.d("test", phpType[1]);

        URLConnector task = new URLConnector(phpType[1]);

        task.start();

        try {
            task.join();
            Log.d("test", "try");
        } catch(InterruptedException e) {
            Log.d("test", ""+e);
        }

        String result = task.getResult();

        Log.d("test", result);

        try {
            JSONArray jarray = new JSONArray(result);   // JSONArray 생성
            for(int i=0; i < jarray.length(); i++){
                JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                subject.setIndex(jObject.getInt("index"));
                subject.setGrade(jObject.getString("grade"));
                subject.setSubject_name(jObject.getString("subject_name"));


                sb.append( //test를 위한 용도
                        "\n" +
                                "인덱스:" + subject.getIndex() +
                                "학번:" + subject.getGrade() +
                                "이름:" + subject.getSubject_name()
                );
            }
            Log.d("test", sb.toString()); //test를 위한 용도

        } catch (JSONException e) {
            Log.d("test", ""+e);
            e.printStackTrace();
        }
    }
    public void result(Post post){

        Log.d("test", phpType[2]);

        URLConnector task = new URLConnector(phpType[2]);

        task.start();

        try {
            task.join();
            Log.d("test", "try");
        } catch(InterruptedException e) {
            Log.d("test", ""+e);
        }

        String result = task.getResult();

        Log.d("test", result);

        try {
            JSONArray jarray = new JSONArray(result);   // JSONArray 생성
            for(int i=0; i < jarray.length(); i++){
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

                sb.append( //test를 위한 용도
                        "\n" +
                                "인덱스:" + post.getIndex() +
                                "과목:" + post.getSubject_name() +
                                "아이디:" + post.getUser_id() +
                                "제목:" + post.getTitle() +
                                "내용:" + post.getContent() +
                                "날짜:" + post.getEdit_date() +
                                "like:" + post.getLike_count() +
                                "점수:" + post.getPoint() +
                                "점수합:" + post.getPoint_sum() +
                                "점수갯수:" + post.getPoint_count() +
                                "조회수:" + post.getView_count()
                );
            }
            Log.d("test", sb.toString()); //test를 위한 용도

        } catch (JSONException e) {
            Log.d("test", ""+e);
            e.printStackTrace();
        }
    }
    public void result(Comment comment){

        Log.d("test", phpType[0]);

        URLConnector task = new URLConnector(phpType[0]);

        task.start();

        try {
            task.join();
            Log.d("test", "try");
        } catch(InterruptedException e) {
            Log.d("test", ""+e);
        }

        String result = task.getResult();

        Log.d("test", result);

        try {
            JSONArray jarray = new JSONArray(result);   // JSONArray 생성
            for(int i=0; i < jarray.length(); i++){
                JSONObject jObject = jarray.getJSONObject(i);  // JSONObject 추출
                comment.setIndex(jObject.getInt("index"));
                comment.setPost_index(jObject.getInt("post_index"));
                comment.setUser_id(jObject.getString("user_id"));
                comment.setContent(jObject.getString("content"));
                comment.setEdit_date(jObject.getString("edit_date"));
                comment.setLike_count(jObject.getInt("like_count"));

                sb.append( //test를 위한 용도
                        "\n" +
                                "인덱스:" + comment.getIndex() +
                                "과목인덱스:" + comment.getPost_index() +
                                "아이디:" + comment.getUser_id() +
                                "내용:" + comment.getContent() +
                                "날짜:" + comment.getEdit_date() +
                                "like:" + comment.getLike_count()
                );
            }
            Log.d("test", sb.toString()); //test를 위한 용도

        } catch (JSONException e) {
            Log.d("test", ""+e);
            e.printStackTrace();
        }
    }
}
