package com.example.randolph.hackathon;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    SqlQuery sql;
    private Button blogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        blogin = (Button) findViewById(R.id.btnlogin);
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean auth = false;
                EditText uname = (EditText) findViewById(R.id.txtuname);
                EditText upass = (EditText) findViewById(R.id.txtupass);

                try {
                    auth = sql.isRegistered(uname.getText().toString(), upass.getText().toString());
                    if(auth == true){
                        Intent i = new Intent(getApplicationContext(), MainMenu.class);
                        startActivity(i);
                    }
                    else
                        Snackbar.make(null, "user account does not exist!", Snackbar.LENGTH_LONG).show();
                } catch (Exception e) {
                    Snackbar.make(null, "user account does not exist! " + e.getMessage(), Snackbar.LENGTH_LONG).show();
                }


            }
        });
    }
}
