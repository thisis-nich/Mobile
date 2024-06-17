package com.example.demosharepreference.app;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demosharepreference.MainActivity;
import com.example.demosharepreference.data.local.UserSharePreference;

public class BaseActivity extends AppCompatActivity {
    protected final static String USERNAME = "admin";
    protected final static String PASSWORD = "123";
    protected void showMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        if(!UserSharePreference.getUsername(this).equals("")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}