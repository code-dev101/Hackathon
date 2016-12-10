package com.example.randolph.hackathon;

import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class QR extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
    }

    public void HandleClick(View view) {
//       try{
//           Intent intent = new Intent("com.google.zxing.client.android.SCAN");
//           intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
//           startActivityForResult(intent, 0);
//       }catch(Exception e){
//           Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
//           Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
//           startActivity(marketIntent);
//       }

        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view<br />
        setContentView(mScannerView);
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.<br />
        mScannerView.startCamera();

    }
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();   // Stop camera on pause<br />
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here</p>
//
    //    final int e = Log.e(rawResult.getText());// Prints scan results<br />
        //Log.e(rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)</p>
        // show the scanner result into dialog box.<br />
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setMessage(rawResult.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();
    }




}
