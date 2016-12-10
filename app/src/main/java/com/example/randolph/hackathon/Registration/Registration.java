package com.example.randolph.hackathon.Registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.randolph.hackathon.Connection;
import com.example.randolph.hackathon.R;
import com.example.randolph.hackathon.SqlQuery;

import java.util.Date;

public class Registration extends AppCompatActivity {
    private String firstName, middleame, lastname, address, emailadd, cardnumber;
    private Date birthday;
    private int contactNum, pinCode;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        middleame = "";

<<<<<<< HEAD
=======
        EditText etFirstName = (EditText)findViewById(R.id.fname);
        EditText etMiddleName = (EditText)findViewById(R.id.mname);
        EditText etLastName = (EditText)findViewById(R.id.lname);
        EditText etAddress = (EditText)findViewById(R.id.address);
        EditText etEmailAdd = (EditText)findViewById(R.id.Em);
        EditText etCardNum = (EditText)findViewById(R.id.cardnum);
        DatePicker dpBirthday = (DatePicker) findViewById(R.id.birthday);
        EditText etContactNum = (EditText)findViewById(R.id.contact);
        EditText etPinCode = (EditText)findViewById(R.id.pincode);
        EditText etUsername = (EditText)findViewById(R.id.username);
        EditText etPassword = (EditText)findViewById(R.id.password);
        Button btReg = (Button)findViewById(R.id.btnReg);
>>>>>>> 7822bc4af474315ec5a9b60e970ae7a6e401d440
    }

    public void checkConnection(){
        try{
            Connection.checkNetworkAvailability(this);
            login();

        } catch (Exception e){
            e.printStackTrace();
            return;
        }

    }

    public void login(){
        //save user data to database
        

    }


}
