package com.example.emicalculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

// Imported classes and packages
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    // UI elements
    private EditText mortgageAmount; // Input field for mortgage amount
    private EditText tenure; // Input field for tenure in months
    private EditText interestRate; // Input field for interest rate
    private Button calculateButton; // Button to calculate EMI

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        // Initialize UI elements
        mortgageAmount = findViewById(R.id.mortgageAmount);
        tenure = findViewById(R.id.tenure);
        interestRate = findViewById(R.id.interestRate);
        calculateButton = findViewById(R.id.calculateButton);

        // Set a click listener for the calculate button
        calculateButton.setOnClickListener(v -> {
            calculateEMI(); // Call the method to calculate EMI
        });
    }

    // Method to calculate EMI
    private void calculateEMI() {
        // Check if all fields are filled
        if (mortgageAmount.getText().toString().isEmpty() || tenure.getText().toString().isEmpty() || interestRate.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter all values", Toast.LENGTH_SHORT).show();
            return; // Exit the method if any field is empty
        }

        // Calculate EMI using the EMI formula
        double principal = Double.parseDouble(mortgageAmount.getText().toString());
        double tenureInMonths = Double.parseDouble(tenure.getText().toString());
        double rateInMonths = Double.parseDouble(interestRate.getText().toString()) / 12 / 100; // Convert to monthly
        double emi = principal * (rateInMonths * Math.pow(1 + rateInMonths, tenureInMonths)) / (Math.pow(1 + rateInMonths, tenureInMonths) - 1);

        // Create an intent to start the ResultActivity
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("emi", String.format("%.2f", emi));
        startActivity(intent); // Start the ResultActivity
    }
}