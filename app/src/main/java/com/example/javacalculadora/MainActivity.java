package com.example.javacalculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin, btnExit;
    private EditText txtUser, txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();

        btnLogin.setOnClickListener(v -> {
            login();
        });

        btnExit.setOnClickListener(v -> {
            exit();
        });

    }

    private void initializeComponents(){
        btnLogin = findViewById(R.id.btnLogin);
        btnExit = findViewById(R.id.btnExit);
        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
    }

    private void login(){
        String strUser = getResources().getString(R.string.user);
        String strPass = getResources().getString(R.string.pass);

        if ((txtUser.getText().toString().equals(strUser)) && (txtPass.getText().toString().equals(strPass))){
            Bundle bundle = new Bundle();
            bundle.putString("user", strUser);

            Intent intent = new Intent(this, CalculatorActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            return;

        }

        Toast.makeText(MainActivity.this, "Invalid User or Password", Toast.LENGTH_SHORT).show();
    }

    private void exit(){
        new AlertDialog.Builder(this)
                .setTitle("Calculator")
                .setMessage("Would you like to exit?")
                .setPositiveButton("Confirm", (dialog, which) -> finish())
                .setNegativeButton("Cancel", null)
                .show();
    }
}