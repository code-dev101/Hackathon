package com.example.randolph.hackathon;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by GLYCHING on 12/10/2016.
 */

public class Connection {
    public static void checkNetworkAvailability(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected())) {
         //   throw new NetworkErrorException("You are not currently connected to the internet.");
        }
    }
}
