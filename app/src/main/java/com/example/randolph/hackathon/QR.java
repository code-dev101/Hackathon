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

        txtIndicate.setVisibility(View.INVISIBLE);
        txtpin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(txtpin.getTextSize() == 4){
                    if(txtpin.getText().toString().equals("4000"));
                    {
                        Toast.makeText(getApplicationContext(), "Coorect Pin!" , Toast.LENGTH_SHORT);
                        txtIndicate.setVisibility(View.INVISIBLE);

                    }
                }else{
                    txtIndicate.setVisibility(View.VISIBLE);

                }
            }
        });
        final AlertDialog.Builder imgBuilder = new AlertDialog.Builder(QR.this);
        imgBuilder.setView(promptView)
                .setCancelable(false);

        final AlertDialog alertDialog = imgBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        alertDialog.show();
    }

}
