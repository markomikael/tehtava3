package com.example.tehtava3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ArrayList <Date> date = new ArrayList<>();
    private Button alertbutton;
    AlertDialog.Builder builder;
    private adapteri omadapteri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.alertbutton = findViewById(R.id.alertbutton);
        builder = new AlertDialog.Builder(this);

        date = new ArrayList<Date>();

        omadapteri = new adapteri(this,R.layout.omalayout,date);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(omadapteri);




        this.alertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder.setMessage("Haluatko lisätä päivämäärän?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Date aika = Calendar.getInstance().getTime();
                                omadapteri.add(aika);


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("ALERTDIALOG HARJOITUS");
                alert.show();
            }
        });
        //dateArrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,date);
       // listView.setAdapter(dateArrayAdapter);


    }
}
