package com.example.ratingstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.ratingstar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        listenerForRatingBar();
        onButtonClickListener();
    }

    public void listenerForRatingBar() {
        binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {

                if (rating == 1.0) {
                    binding.textView.setText("Your rating is only: " + String.valueOf(rating)+ " star!");
                }

                if (rating >= 2.0 && rating <=3.0) {
                    binding.textView.setText("You collect " + String.valueOf(rating)+ " stars. Nice try!");
                }

                if (rating == 4) {
                    binding.textView.setText("You are cool! You bring " + String.valueOf(rating)+ " stars!");
                }

                if (rating == 5.0) {
                    binding.textView.setText("Well, " + String.valueOf(rating)+ " stars. \n Someone won the jackpot! ");
                }
            }
        });
    }

    public void onButtonClickListener() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.ratingBar.getRating() == 1) {
                    Toast.makeText(MainActivity.this, "You have received " + String.valueOf(binding.ratingBar.getRating())+ " star, oh no!", Toast.LENGTH_SHORT).show();
                }
                /*else
                    Toast.makeText(MainActivity.this, "You have received " + String.valueOf(ratingBar.getRating())+ " stars, good", Toast.LENGTH_SHORT).show(); */

                if (binding.ratingBar.getRating() >= 2 && binding.ratingBar.getRating() <= 3) {
                    Toast.makeText(MainActivity.this, "You have received " + String.valueOf(binding.ratingBar.getRating())+ " stars. You progress!", Toast.LENGTH_SHORT).show();
                }

                if (binding.ratingBar.getRating() == 4) {
                    Toast.makeText(MainActivity.this, "You have received " + String.valueOf(binding.ratingBar.getRating())+ " stars. Very well!", Toast.LENGTH_SHORT).show();
                }

                if (binding.ratingBar.getRating() == 5) {
                    Toast.makeText(MainActivity.this, "Congrats, buddy. You have " + binding.ratingBar.getRating() + " stars!", Toast.LENGTH_SHORT).show();}
            }
        });
    }
}