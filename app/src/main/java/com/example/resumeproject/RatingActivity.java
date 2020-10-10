package com.example.resumeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RatingActivity extends AppCompatActivity {

    private static float numStars = 3; //Set static ratingBar value.
    ArrayList<Comment> comments; //Create ArrayList for our RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        // Overrides ratingBar method so it's value can be passed to MainActivity onClick.
        final RatingBar userRating = findViewById(R.id.ratingBar1);

        userRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                numStars = userRating.getRating();
            }
        });


        SharedPreferences namesPref = getSharedPreferences("NAMES", MODE_PRIVATE);
        SharedPreferences commentsPref = getSharedPreferences("COMMENTS", MODE_PRIVATE);
        Map<String, String> nameMap = (Map<String, String>) namesPref.getAll();
        Map<String, String> commentsMap = (Map<String, String>) commentsPref.getAll();
        RecyclerView rvComments = (RecyclerView) findViewById(R.id.rvComments);
        comments = Comment.createCommentsList(nameMap, commentsMap);
        CommentsAdapter adapter = new CommentsAdapter(comments);
        rvComments.setAdapter(adapter);
        rvComments.setLayoutManager(new LinearLayoutManager(this));


    }

    public void addButtonClick (View view){
        EditText mName = (EditText) findViewById(R.id.newName);
        EditText mComment = (EditText) findViewById(R.id.newComment);
        SharedPreferences namePrefs = getSharedPreferences("NAMES", MODE_PRIVATE);
        SharedPreferences commentPrefs = getSharedPreferences("COMMENTS", MODE_PRIVATE);
        SharedPreferences recentPrefs = getSharedPreferences("RECENTPREFS", MODE_PRIVATE);
        namePrefs.edit().putString(mName.getText().toString(), mName.getText().toString()).apply();
        commentPrefs.edit().putString(mName.getText().toString(), mComment.getText().toString()).apply();
        recentPrefs.edit().putString("VALUE", mComment.getText().toString()).apply();
    }

    public static float getData(){
        return numStars;
    }
}