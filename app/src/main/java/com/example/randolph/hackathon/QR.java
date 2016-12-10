package com.example.randolph.hackathon;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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
    private int temp = 10000;

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
    public void handleResult(Result rawResult) {

        int amount = Integer.parseInt(rawResult.getText());
        temp -= amount;
        Toast.makeText(getApplicationContext(), Integer.toString(temp), Toast.LENGTH_SHORT).show();
        LayoutInflater layoutInflater = LayoutInflater.from(QR.this);
        View promptView = layoutInflater.inflate(R.layout.validatepin,null);
        final EditText txtpin = (EditText) promptView.findViewById(R.id.txt_pin);
        final TextView txtIndicate = (TextView)  promptView.findViewById(R.id.txt_indicate);
        
        Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnclear,btnXx;
        btn1 = (Button) promptView.findViewById(R.id.btn_1);
        btn2 = (Button) promptView.findViewById(R.id.btn_2);
        btn3 = (Button) promptView.findViewById(R.id.btn_3);
        btn4 = (Button) promptView.findViewById(R.id.btn_4);
        btn5 = (Button) promptView.findViewById(R.id.btn_5);
        btn6 = (Button) promptView.findViewById(R.id.btn_6);
        btn7 = (Button) promptView.findViewById(R.id.btn_7);
        btn8 = (Button) promptView.findViewById(R.id.btn_8);
        btn9 = (Button) promptView.findViewById(R.id.btn_9);
        btn0 = (Button) promptView.findViewById(R.id.btn_1);
        btnclear = (Button) promptView.findViewById(R.id.btn_clear);
        btnXx = (Button) promptView.findViewById(R.id.btnX);

        Button [] btnArray = new Button[]{btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnclear,btnXx};
        for(Button b : btnArray){
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                                        
                }
            });
        }
        txtIndicate.setVisibility(View.INVISIBLE);

        final AlertDialog.Builder imgBuilder = new AlertDialog.Builder(QR.this);
        imgBuilder.setView(promptView)
                .setCancelable(false);

        final AlertDialog alertDialog = imgBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        alertDialog.show();
    }

}
