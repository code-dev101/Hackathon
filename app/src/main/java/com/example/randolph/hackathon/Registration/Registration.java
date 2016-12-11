package com.example.randolph.hackathon.Registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.randolph.hackathon.Connection;
import com.example.randolph.hackathon.Login;
import com.example.randolph.hackathon.MainMenu;
import com.example.randolph.hackathon.R;
import com.example.randolph.hackathon.SqlQuery;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Registration extends AppCompatActivity {
    private String firstName, middleName, lastName, address, emailAdd, cardNumber;
    private String birthday, year, month, day;
    private String contactNum, pinCode;
    private String username, password;
    private String fullName;



    EditText etFirstName;
    EditText etMiddleName;
    EditText etLastName;
    EditText etAddress;
    EditText etEmailAdd;
    EditText etCardNum;
    DatePicker dpBirthday;
    EditText etContactNum;
    EditText etPinCode;
    EditText etUsername;
    EditText etPassword;
    Button btReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ///delete later
        SqlQuery.createTable(this);
        //TEST

        etFirstName = (EditText)findViewById(R.id.fname);
        etMiddleName = (EditText)findViewById(R.id.mname);
        etLastName = (EditText)findViewById(R.id.lname);
        etAddress = (EditText)findViewById(R.id.address);
        etEmailAdd = (EditText)findViewById(R.id.emailaddress);
        etCardNum = (EditText)findViewById(R.id.cardnumber);
        dpBirthday = (DatePicker) findViewById(R.id.birthday);
        etContactNum = (EditText)findViewById(R.id.contact);
        etPinCode = (EditText)findViewById(R.id.pincode);
        etUsername = (EditText)findViewById(R.id.username);
        etPassword = (EditText)findViewById(R.id.password);
        btReg = (Button)findViewById(R.id.btncreate);

        btReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadMenu = new Intent(getApplicationContext(), Login.class);
                startActivity(loadMenu);
            }
        });

    }



    public void createAccount(View view){
        //save user data to database
        firstName = etFirstName.getText().toString();
        middleName = etMiddleName.getText().toString();
        lastName = etLastName.getText().toString();
        address = etAddress.getText().toString();
        year = Integer.toString(dpBirthday.getYear());
        month = Integer.toString(dpBirthday.getMonth());
        day = Integer.toString(dpBirthday.getDayOfMonth());
        contactNum = etContactNum.getText().toString();
        emailAdd = etEmailAdd.getText().toString();
        cardNumber = etCardNum.getText().toString();
        pinCode = etPinCode.getText().toString();
        username = etUsername.getText().toString();
        password = etPassword.getText().toString();
        birthday = year + "-" + month + "-" + day;


        SqlQuery query = new SqlQuery();
        query.createAccount(username, password, firstName, middleName, lastName, birthday, contactNum, emailAdd, cardNumber, pinCode);


        Toast.makeText(this, "Successfully created an account.", Toast.LENGTH_SHORT).show();

    }




}
