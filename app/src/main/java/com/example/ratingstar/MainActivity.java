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
        clickOnRatingBar();
        onGivingRateButton();
        onResetRateButton();
    }

    public void clickOnRatingBar() {
        binding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {

                if (rating == 1.0) {
                    Toast.makeText(MainActivity.this, "You have selected "
                            + binding.ratingBar.getRating() + " star!", Toast.LENGTH_SHORT).show();
                } else if (rating >= 2.0 && rating <= 3.0) {
                    Toast.makeText(MainActivity.this, "You have selected "
                            + binding.ratingBar.getRating() + " stars!", Toast.LENGTH_SHORT).show();

                } else if (rating == 4) {
                    Toast.makeText(MainActivity.this, "You have selected "
                            + binding.ratingBar.getRating() + " stars!", Toast.LENGTH_SHORT).show();
                } else if (rating == 5.0) {
                    Toast.makeText(MainActivity.this, "You have selected "
                            + binding.ratingBar.getRating() + " stars!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onGivingRateButton() {
        binding.givingRateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.ratingBar.getRating() == 1) {
                    binding.ratingTV.setText(R.string.given1starText);
                } else if (binding.ratingBar.getRating() == 2) {
                    binding.ratingTV.setText(R.string.given2starsText);
                } else if (binding.ratingBar.getRating() == 3) {
                    binding.ratingTV.setText(R.string.given3starsText);
                } else if (binding.ratingBar.getRating() == 4) {
                    binding.ratingTV.setText(R.string.given4starsText);
                } else if (binding.ratingBar.getRating() == 5) {
                    binding.ratingTV.setText(R.string.given5starsText);
                }
            }
        });
    }

    public void onResetRateButton() {
        binding.resetRatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.ratingTV.setText(R.string.afterResetText);
                binding.ratingBar.setRating(0);
            }
        });
    }
}