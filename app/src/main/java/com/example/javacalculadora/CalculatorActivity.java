package com.example.javacalculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CalculatorActivity extends AppCompatActivity {
    private Button btnAdd ;
    private Button btnSubstract;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnClear;
    private Button btnReturn;
    private EditText txtNum1;
    private EditText txtNum2;
   private TextView lblResult;

    private final Calculator calculator = new Calculator(0,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initializeComponents();


    }

    private void initializeComponents(){
        btnAdd = findViewById(R.id.btnAdd);
        btnSubstract = findViewById(R.id.btnSubstract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnClear = findViewById(R.id.btnClear);
        btnReturn = findViewById(R.id.btnReturn);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        lblResult = findViewById(R.id.lblResult);
    }

    private void btnReturn(){
        new AlertDialog.Builder(this)
                .setTitle("Calculator")
                .setMessage("Would you like to return?")
                .setPositiveButton("Confirm", (dialog, which) -> finish())
                .setNegativeButton("Cancel", null)
                .show();

    }

    private void clear(){
        this.txtNum1.setText("");
        this.txtNum2.setText("");
        this.lblResult.setText("");
    }

    private boolean validateFields(){
        if (this.txtNum1.getText().toString().matches("") || this.txtNum2.getText().toString().matches("")){
            Toast.makeText(CalculatorActivity.this, "Values Required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void setCalculatorValues(){
            calculator.setNum1(Integer.parseInt(txtNum1.getText().toString()));
            calculator.setNum2(Integer.parseInt(txtNum2.getText().toString()));
    }

    private void add(){
        if (validateFields()){
            setCalculatorValues();
        }

    }

    private void substract(){

    }

    private void multiply(){

    }

    private void divide(){

    }


}