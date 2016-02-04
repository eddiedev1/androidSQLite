package com.example.eddie.dunna;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    //database in used
    DatabaseHelper db;

    Button displayDataButton, updateDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //instance of database in used...
        db = new DatabaseHelper(this);

        //cast displayDataButton and updateDataButton
        displayDataButton = (Button) findViewById(R.id.displayDataButton);
        updateDataButton = (Button) findViewById(R.id.updateDataButton);

        //call viewData method to display all saved data
        viewData();
    }

    //this method is to display all the data
    public void viewData(){
        displayDataButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //all the info gathered save on Cursor object
                        Cursor res = db.getAllData();

                        // implementing if res = 0, there is no data stored in database
                        if(res.getCount() == 0){
                            //call showMessage method below to - message to show if statement is true
                            showMessage("Error", "No data found");

                            return;
                        }
                        //if there is data in the data base
                        //use this string buffer
                        StringBuffer buffer = new StringBuffer();

                        //while to get all data and store in buffer
                        while(res.moveToNext()){
                            //all columns in data base from index 0 to lastone
                            buffer.append("Id :"+res.getString(0)+"\n");
                            buffer.append("Name :"+res.getString(1)+"\n");
                            buffer.append("Email :"+res.getString(2)+"\n");
                            buffer.append("Phone :"+res.getString(3)+"\n\n");
                        }
                        //show all the data
                        showMessage("Data", buffer.toString());

                    }
                }
        );
    }

    public void showMessage (String tittle, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tittle);
        builder.setMessage(Message);
        //this will show dialog
        builder.show();

    }
}
