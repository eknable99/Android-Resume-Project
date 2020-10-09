package com.example.resumeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import java.util.HashMap;
import java.util.Map;

public class RatingActivity extends AppCompatActivity {

    private static float numStars = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        final RatingBar userRating = findViewById(R.id.ratingBar1);

        userRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                numStars = userRating.getRating();
            }
        });

    }
    public static float getData(){
        return numStars;
    }



//    public void switchToMainActivity(View view){
//        RatingBar userRating = findViewById(R.id.ratingBar1);
//        numStars = userRating.getRating();
//
////        Intent intent = new Intent(this, MainActivity.class);
////
////        intent.putExtra("id1", numStars);
////
////        Map<String, Float> ratingsMap = new HashMap<>();
//    }
}