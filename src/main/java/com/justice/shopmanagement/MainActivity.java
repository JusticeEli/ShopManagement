package com.justice.shopmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.justice.shopmanagement.alldata.AllData;
import com.justice.shopmanagement.user.UserLoginData;

public class MainActivity extends AppCompatActivity {
    private static final int WRITE_READ_PERMISSION =1 ;
    private EditText emailEdtTxt, passwordEdtTxt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        setPermissions();
        setOnClickListeners();
    }

    private void setPermissions() {
        String[] permissions={Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        if((ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)&&(ContextCompat.checkSelfPermission(this
        ,Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED)){
          //  Toast.makeText(this, "permissions granted", Toast.LENGTH_SHORT).show();
        }else{
            ActivityCompat.requestPermissions(this,permissions,WRITE_READ_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    private void setOnClickListeners() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success = confirmEmailAndPassword();

                if (success) {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, FirstPageActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();


                }

            }
        });
    }

    private boolean confirmEmailAndPassword() {
        String email = emailEdtTxt.getText().toString();
        String password = passwordEdtTxt.getText().toString();
        AllData.readAllDataFromFiles();

        for (UserLoginData user : AllData.userLoginDataList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;

            }


        }
        return true;
    }

    private void initWidgets() {
        emailEdtTxt = findViewById(R.id.emailEdtTxt);
        passwordEdtTxt = findViewById(R.id.passwordEdtTxt);
        loginBtn = findViewById(R.id.loginBtn);


    }
}
