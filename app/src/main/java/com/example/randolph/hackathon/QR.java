package com.example.randolph.hackathon;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class QR extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private double temp = SqlQuery.uCredits;
    private String tempProd = "";
    private String tempPrice= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_qr);

    }

    public void HandleClick(View view) {
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();

    }
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
        setContentView(R.layout.activity_qr);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mScannerView.destroyDrawingCache();
        setContentView(R.layout.activity_qr);
    }

    @Override
    public void handleResult(Result rawResult) {

        try {
            String tempString =  rawResult.getText().toString();
            int index =  rawResult.toString().indexOf(":");
            char [] prod_arr = new char[index];
            char [] prod_price = new char[10];
            tempString.getChars(0,index,prod_arr,0);
            rawResult.getText().getChars(index+1, tempString.length(),prod_price,0);

            for (int a = 0 ; a< prod_arr.length; a++){
                tempProd += String.valueOf(prod_arr[a]);
            }
            for (int i = 0; i < prod_price.length; i++) {
                tempPrice += String.valueOf(prod_price[i]);
            }


//            String prodName = prod_arr.toString();
//`
//            int amount = Integer.parseInt(rawResult.getText());
//            temp -= amount;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), Double.toString(temp-Double.parseDouble(tempPrice)) , Toast.LENGTH_SHORT).show();
        LayoutInflater layoutInflater = LayoutInflater.from(QR.this);
        View promptView = layoutInflater.inflate(R.layout.validatepin,null);
        final EditText txtpin = (EditText) promptView.findViewById(R.id.txt_pin);
        final TextView txtIndicate = (TextView)  promptView.findViewById(R.id.txt_indicate);

        final  Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnclear,btnXx;
        btn1 = (Button) promptView.findViewById(R.id.btn_1);
        btn2 = (Button) promptView.findViewById(R.id.btn_2);
        btn3 = (Button) promptView.findViewById(R.id.btn_3);
        btn4 = (Button) promptView.findViewById(R.id.btn_4);
        btn5 = (Button) promptView.findViewById(R.id.btn_5);
        btn6 = (Button) promptView.findViewById(R.id.btn_6);
        btn7 = (Button) promptView.findViewById(R.id.btn_7);
        btn8 = (Button) promptView.findViewById(R.id.btn_8);
        btn9 = (Button) promptView.findViewById(R.id.btn_9);
        btn0 = (Button) promptView.findViewById(R.id.btn_0);
        btnclear = (Button) promptView.findViewById(R.id.btn_clear);
        btnXx = (Button) promptView.findViewById(R.id.btnX);

        Button [] btnArray = new Button[]{btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnclear,btnXx};

        txtIndicate.setVisibility(View.INVISIBLE);

        final AlertDialog.Builder imgBuilder = new AlertDialog.Builder(QR.this);
        imgBuilder.setView(promptView)
                .setCancelable(false);

        final AlertDialog alertDialog = imgBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        alertDialog.show();
        for(final Button b : btnArray){

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(QR.this, Integer.toString(view.getId()-2131493039), Toast.LENGTH_SHORT).show();
                    if(view.getId()-2131493039 <10) {
                        txtpin.setText(txtpin.getText() + Integer.toString(view.getId()-2131493039));
//                        Toast.makeText(QR.this, Integer.toString(view.getId()-2131493039), Toast.LENGTH_SHORT).show();
                    }
                    else if(view.getId()-2131493039 ==11){
                        txtpin.setText(txtpin.getText()+ Integer.toString(view.getId()-2131493050));
//                        Toast.makeText(QR.this, Integer.toString(view.getId()-2131493050), Toast.LENGTH_SHORT).show();
                    }else if(view.getId()-2131493039==10){
                        txtpin.setText("");
                    }else{
                        int length = txtpin.getText().length();
                        if (length > 0) {
                            txtpin.getText().delete(length - 1, length);
                        }
                    }
                    if(txtpin.getText().toString().equals("4000")){
                        Toast.makeText(QR.this, "Transaction successful!", Toast.LENGTH_SHORT).show();
                        SqlQuery query = new SqlQuery();
                        query.startTransaction(tempProd,Double.parseDouble(tempPrice));
                        Intent i = new Intent(getApplicationContext(), QR.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        alertDialog.dismiss();
                        startActivity(i);

                    }


                }
            });
        }
    }

}
