package com.example.eddie.dunna;

import android.content.Intent;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    //instantiate database here
    DatabaseHelper db;

    EditText editTextName, editTextEmail, editTextPhone;
    Button saveButton, menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        db = new DatabaseHelper(this);


        //cast edittext and buttons
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        saveButton = (Button) findViewById(R.id.saveButton);
        menuButton = (Button) findViewById(R.id.menuButton);
        menuButton.setOnClickListener(this);

        //call method addData every time user click on add data...
        addData();
    }




    //method if click menu button go to menu activity
    public void goToMenu() {
        startActivity(new Intent(this, MenuActivity.class));
    }




    //method to setONClick for saveButton
    public void addData() {
        saveButton.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        //call insertData Method in DatabaseHelper to pass the values entered by use
                        //using textfields
                        //if data is succesfully inserted will return true, else false...
                        boolean isInserted = db.insertData(editTextName.getText().toString(), editTextEmail.getText().toString(),
                                editTextPhone.getText().toString());

                        //if data has been inserted, use toast to display message that data has been inserted
                        //else will display negation...
                        if (isInserted == true) {
                            Toast.makeText(RegistrationActivity.this, "Data inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(RegistrationActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            //if click on register button go to to menu class
            case R.id.menuButton:
                goToMenu();
                break;

        }

    }
}
