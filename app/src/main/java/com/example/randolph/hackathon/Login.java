package com.example.randolph.hackathon;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.randolph.hackathon.Registration.Registration;

public class Login extends AppCompatActivity {
    SqlQuery sql;
    private Button blogin, breg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sql = new SqlQuery();
        try{
            SqlQuery.createTable(this);
        }catch (Exception ex){
            Snackbar.make(null, ex.getMessage(), Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }

        blogin = (Button) findViewById(R.id.btnlogin);
        breg = (Button) findViewById(R.id.btnreg);
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sUname, sUpass;
                EditText uname = (EditText) findViewById(R.id.txtuname);
                EditText upass = (EditText) findViewById(R.id.txtupass);
                sUname = uname.getText().toString();
                sUpass = upass.getText().toString();
                try {

                    boolean auth = sql.isRegistered(sUname, sUpass);
                    if(auth == true){
                        Intent i = new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(i);
                    }
                    else
                        Snackbar.make(v, "user account does not exist!", Snackbar.LENGTH_LONG).show();
                } catch (Exception e) {
                    Snackbar.make(v, "user account does not exist! " + e.getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
        breg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Registration.class);
                startActivity(i);
            }
        });
    }
}
