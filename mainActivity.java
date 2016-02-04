package com.example.eddie.dunna;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //instance of the database that we created in databasehelper class
    DatabaseHelper db;


    Button registerButton,loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initiate database here
        db = new DatabaseHelper(this);

        registerButton = (Button) findViewById(R.id.registerButton);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerButton.setOnClickListener(this);
    }


    //method to go to registration class
    public void goToRegister(){
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    //switch for the register and login buttons
    public void onClick(View view){
        switch (view.getId()){

            //if click on register button go to to regisrter class
            case R.id.registerButton:
                goToRegister();
                break;

        }
    }




}
