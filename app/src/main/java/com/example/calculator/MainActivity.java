package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText number1EditText = findViewById(R.id.number1);
        EditText number2EditText = findViewById(R.id.number2);
        TextView resultTextView = findViewById(R.id.result);
        Button calculateButton = findViewById(R.id.btnCalculate);
        Button clearButton = findViewById(R.id.btnClear);
        Button quitButton = findViewById(R.id.btnQuit);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1String = number1EditText.getText().toString();
                String num2String = number2EditText.getText().toString();

                Double num1 = null;
                Double num2 = null;

                try {
                    num1 = Double.parseDouble(num1String);
                    num2 = Double.parseDouble(num2String);
                } catch (NumberFormatException e) {
                    resultTextView.setText("Invalid input");
                    return;
                }

                double result;
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();

                if (selectedRadioButtonId == R.id.rbAdd) {
                    result = num1 + num2;
                } else if (selectedRadioButtonId == R.id.rbMultiply) {
                    result = num1 * num2;
                } else if (selectedRadioButtonId == R.id.rbSubtract) {
                    result = num1 - num2;
                } else {
                    resultTextView.setText("Select an operation");
                    return;
                }

                // Display the result
                resultTextView.setText("Result: " + result);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all inputs and reset result
                number1EditText.setText("");
                number2EditText.setText("");
                resultTextView.setText("Result: 0");
                radioGroup.clearCheck();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}