package com.example.randolph.hackathon;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Created by user on 12/10/2016.
 */

public class SqlQuery {

    private static SQLiteDatabase db;
    private static Cursor c;
    private static final String TABLE_NAME = "tbl_user";
    private static final String _sUid = "User_id";
    private static final String _sUname = "Username";
    private static final String _sUpass = "Password";
    private static final String _sFname = "Firstname";
    private static final String _sMname = "Middlename";
    private static final String _sLname = "Lastname";
    private static final String _sEmail = "Email";
    private static final String _sCardNm = "Card_number";
    private static final String _sPin = "Pin_code";
    private static final String _sBday = "Birthday";
    private static final String _sContact = "Contact_number";
    public static void createTable(Activity activity){
        try {
            if(activity != null){
                db = activity.openOrCreateDatabase("db_user", Context.MODE_PRIVATE, null);
                db.execSQL("CREATE TABLE IF NOT EXISTS" + TABLE_NAME + " ("+_sUid+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " "+ _sUname+" VARCHAR(30) , "+ _sUpass+" VARCHAR(30), "+ _sFname+" VARCHAR(30), "+ _sMname +" VARCHAR(30)," +
                        " "+ _sLname+ " VARCHAR(30),"+ _sBday+" DATE,"+_sContact+" INTEGER, "+ _sEmail +" VARCHAR(30), "+_sCardNm+" VARCHAR(50), "+ _sPin+ " INTEGER(5)  );");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // _s = String _i = Integer _d = Double --- Variable Standard
    public void createAccount(String sUname, String sUpass, String sFname, String sMname, String sLname,String sBday, String sContact,String sEmail, String sCarnNm,  String sPin){
        try{
            //("+_sUname+", "+_sUpass+" , "+_sFname+", "+_sMname+", "+_sLname+" , "+_sEmail+" ," +"+_sCardNm+", "+_sPin+")
            db.execSQL("INSERT INTO  "+ TABLE_NAME+"  VALUES (1, '"+sUname+"','"+sUpass+"','"+sFname+"', '"+sMname+"', '"+sLname+"', '"+sBday+"' , "+sContact+", '"+sEmail+"' , '"+sCarnNm+"', "+sPin+");");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void ediAccount(String sUname, String sUpass, String sFname, String sMname, String sLname,String sBday, String sContact,String sEmail, String sCarnNm,  String sPin)
    {
        try {
            db.execSQL("UPDATE "+TABLE_NAME+ " SET ('"+_sUname+"', '"+_sUpass+"' , '"+_sFname+"', '"+_sMname+"', '"+_sLname+"' , '"+_sBday+"', "+_sContact+",'"+_sEmail+"' ,'"+_sCardNm+"', "+_sPin+") " +
                    "= ('"+sUname+"','"+sUpass+"','"+sFname+"', '"+sMname+"', '"+sLname+"', '"+sBday+"' , "+sContact+", '"+sEmail+"' , '"+sCarnNm+"', "+sPin+") WHERE "+_sCardNm+"   = '"+sCarnNm+"' ");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
