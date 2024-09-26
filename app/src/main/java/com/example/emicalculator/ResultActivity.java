package com.example.emicalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Imported classes and packages
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    // UI elements
    private TextView emiResult; // Text view to display EMI result
    private Button backButton; // Button to go back to the main activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        // Initialize UI elements
        emiResult = findViewById(R.id.emiResult);
        backButton = findViewById(R.id.backButton);

        // Retrieve the EMI result from the intent
        String emi = getIntent().getStringExtra("emi");

        // Display the EMI result in the TextView
        emiResult.setText("Monthly EMI: $" + emi);

        // Set a click listener for the back button
        backButton.setOnClickListener(v -> {
            finish(); // Close this activity and return to the previous one
        });

    }
}