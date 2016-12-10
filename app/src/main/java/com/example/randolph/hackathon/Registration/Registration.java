package com.example.randolph.hackathon.Registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.randolph.hackathon.Connection;
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

    EditText etFirstName = (EditText)findViewById(R.id.fname);
    EditText etMiddleName = (EditText)findViewById(R.id.mname);
    EditText etLastName = (EditText)findViewById(R.id.lname);
    EditText etAddress = (EditText)findViewById(R.id.address);
    EditText etEmailAdd = (EditText)findViewById(R.id.emailaddress);
    EditText etCardNum = (EditText)findViewById(R.id.cardnumber);
    DatePicker dpBirthday = (DatePicker) findViewById(R.id.birthday);
    EditText etContactNum = (EditText)findViewById(R.id.contact);
    EditText etPinCode = (EditText)findViewById(R.id.pincode);
    EditText etUsername = (EditText)findViewById(R.id.username);
    EditText etPassword = (EditText)findViewById(R.id.password);
    Button btReg = (Button)findViewById(R.id.btncreate);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        middleName = "";

    }


    public void createAccount(){
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

    }


}
