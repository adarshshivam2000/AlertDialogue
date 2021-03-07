package com.example.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView name, acc, bal;
    Button btnName, btnAcc, btnBal;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = (TextView) findViewById(R.id.name);
        acc = (TextView) findViewById(R.id.acc);
        bal = (TextView) findViewById(R.id.bal);
        btnName = (Button) findViewById(R.id.btnName);
        btnAcc = (Button) findViewById(R.id.btnAcc);
        btnBal = (Button) findViewById(R.id.btnBal);

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("Adarsh");
            }
        });

        btnAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acc.setText("SBIN4603 ");
            }
        });

        /*
         *
         * builder class in java concept
         * setPosit
         * */
        btnBal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         //   inflate-> Fill
                View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_alert_dialog2,null);
                final EditText UserName = (EditText) view.findViewById(R.id.UserName);
                final  EditText Password =(EditText) view.findViewById(R.id.Password);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Login Here")
                        .setView(view)
                        .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String u;
                                u = UserName.getText().toString();
                                String p;
                                p = Password.getText().toString();

                                if(u.equals("Adarsh") && p.equals("12345678")) {
                                    bal.setText("500");
                                }
                                else {
                                    bal.setText("Sorry Invalid Password! Try again");
                                }
                            }
                        })
                        .setNegativeButton("cancel", null)
                        .setCancelable(true);

                AlertDialog alert = builder.create();
                alert.show();

            }
        });
    }


    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Really Exit")                                                         /*
                                                                                                        public void onBackPressed(){
                                                                                                        ka use back button ke change karne me use hota hai

                                                                                                     MainActivity.super.onBackPressed(); back karane me kaam aata h
                                                                                                    */
                .setMessage("Do you Really Want?")

                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();

                    }
                })
                .setNegativeButton("cancel", null)
                .setCancelable(false);
        AlertDialog alert = builder.create();
        alert.show();
    }
}

