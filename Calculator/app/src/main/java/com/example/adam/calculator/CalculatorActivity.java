package com.example.adam.calculator;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.adam.calculator.R.id.textView2;

public class CalculatorActivity extends AppCompatActivity {


    private String display = "0";
    private double accumulator = 0.0;

    private Operation currentOperation = Operation.NONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void keyClicked(View view) {

        Button button = (Button) view;

        String key = button.getText().toString();

        TextView displayTextView = (TextView) findViewById(R.id.textView2);


//        findViewById(textView2);


        switch (key) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if(display.equals("0")) {
                    display = "";
                }
                display += key;
                break;

            case "+":
            case "-":
                calculateOperation(key);
                break;
            
            case "=":


                calculateResult();
                break;


        }

        displayTextView.setText(display);

    }

    private void calculateResult() {

        double displayValue = Double.parseDouble(display);

        switch (currentOperation) {

            case ADD:
                displayResult(accumulator + displayValue);
                break;

            case SUBSTRACT:
                displayResult(accumulator - displayValue);
                break;
        }

        accumulator = 0.0;
        currentOperation = Operation.NONE;
    }

    private void displayResult(double result) {

        if(result == (long) result) {
            display = String.format("%d", (long) result);
        } else
            display = String.format("%s", result);

    }

    private void calculateOperation(String key) {

        currentOperation = Operation.operationFromKey(key);
        accumulator = Double.parseDouble(display);
        display = "0";
    }
}
