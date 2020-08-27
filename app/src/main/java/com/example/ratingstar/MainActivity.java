package com.example.ratingstar;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    RatingBar ratingBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listenerForRatingBar();

        onButtonClickListener();



    }

    public void listenerForRatingBar(){

        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.textView);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {

                if(rating == 1.0) {
                    textView.setText("Your rating is only: " + String.valueOf(rating)+ " star!");
                }

                if(rating >= 2.0 && rating <=3.0) {
                    textView.setText("You collect " + String.valueOf(rating)+ " stars. Nice try!");
                }

                if(rating == 4) {
                    textView.setText("You are cool! You bring " + String.valueOf(rating)+ " stars!");
                }

                if(rating == 5.0) {
                    textView.setText("Well, " + String.valueOf(rating)+ " stars. \n Someone won the jackpot! ");
                }


                /*else {
                    textView.setText("Your rating is: " + String.valueOf(rating)+ " lucky stars!");
                }*/

            }
        });
    }

    public void onButtonClickListener(){

        ratingBar = findViewById(R.id.ratingBar);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ratingBar.getRating() == 1)
                {
                    Toast.makeText(MainActivity.this, "You have received " + String.valueOf(ratingBar.getRating())+ " star, oh no!", Toast.LENGTH_SHORT).show();
                }
                /*else
                    Toast.makeText(MainActivity.this, "You have received " + String.valueOf(ratingBar.getRating())+ " stars, good", Toast.LENGTH_SHORT).show(); */

                if (ratingBar.getRating() >= 2 && ratingBar.getRating() <= 3)
                {
                    Toast.makeText(MainActivity.this, "You have received " + String.valueOf(ratingBar.getRating())+ " stars. You progress!", Toast.LENGTH_SHORT).show();
                }

                if (ratingBar.getRating() == 4)
                {
                    Toast.makeText(MainActivity.this, "You have received " + String.valueOf(ratingBar.getRating())+ " stars. Very well!", Toast.LENGTH_SHORT).show();
                }

                if (ratingBar.getRating() == 5)
                {Toast.makeText(MainActivity.this, "Congrats, buddy. You have " + String.valueOf(ratingBar.getRating())+ " stars!", Toast.LENGTH_SHORT).show();}



            }
        });


    }



}