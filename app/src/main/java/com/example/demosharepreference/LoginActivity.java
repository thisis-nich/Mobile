package com.example.demosharepreference;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demosharepreference.app.BaseActivity;
import com.example.demosharepreference.data.local.UserSharePreference;

public class LoginActivity extends BaseActivity {
    private EditText etUsername, etPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }
    public void initView(){
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                if(username.isEmpty()){
                    showMessage("Please enter username");
                    return;
                }
                if(password.isEmpty()){
                    showMessage("Please enter password");
                    return;
                }
                if(!username.equals(USERNAME)){
                    showMessage("Your username incorrect!");
                    return;
                }
                if(!password.equals(PASSWORD)){
                    showMessage("Your password incorrect!");
                    return;
                }
                UserSharePreference.saveUserLogin(
                        LoginActivity.this,
                        username,
                        password
                );
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                showMessage("Login Success!");
            }
        });
    }
}