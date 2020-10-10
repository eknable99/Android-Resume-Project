package com.example.resumeproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatingBar ratingBarSmall = findViewById(R.id.ratingBarSmall);
        ratingBarSmall.setRating(RatingActivity.getData());

        SharedPreferences recentPrefs = getSharedPreferences("RECENTPREFS", MODE_PRIVATE);

        TextView recentComment = findViewById(R.id.recentComment);
        recentComment.setText(recentPrefs.getString("VALUE", "No Recent Comments"));


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Toast.makeText(this, "Your Android Version is Up To Date", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Please Update Your Android Version", Toast.LENGTH_LONG).show();
        }
    }


    public void switchToRatingActivity(View view){
        Intent intent = new Intent(this, RatingActivity.class);
        startActivity(intent);
    }

    public void switchToPortfolioActivity(View view){
        Intent intent = new Intent(this, PortfolioActivity.class);
        startActivity(intent);
    }
}