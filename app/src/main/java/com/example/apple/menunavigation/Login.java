package com.example.apple.menunavigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button btLogin;
    private EditText etUser,etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btLogin = (Button)findViewById(R.id.btLogin);
        etUser = (EditText)findViewById(R.id.editUser);
        etPass = (EditText)findViewById(R.id.editpass);
        clickLogin();
    }

    private void clickLogin() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUser.getText().toString();
                String password = etPass.getText().toString();
                if (username.equals("admin") && password.equals("1234")) {
                    String msg = "Welcome Chicken";
                    Toast.makeText(Login.this, msg, Toast.LENGTH_SHORT).show();
                    Intent objIntent = new Intent(Login.this, MainActivity.class);
                    startActivity(objIntent);
                    finish();
                }
            }
        });
    }
}
