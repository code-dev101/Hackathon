package com.example.randolph.hackathon;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 12/10/2016.
 */

public class SqlQuery {

    private static SQLiteDatabase db;
    private static Cursor c;
    private static final String TABLE_USER = "tbl_user";
    private static final String TABLE_CATEGORY = "tbl_category";
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
    private static final String _sCategory = "Category";
    private static final String _sPct = "Percentage";
    private static String uID ="";

    public static void createTable(Activity activity){
        try {

            if(activity != null){
                db = activity.openOrCreateDatabase("db_user", Context.MODE_PRIVATE, null);
                //CREATE USER TABLE
                db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_USER + " ("+_sUid+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " "+ _sUname+" VARCHAR(30) , "+ _sUpass+" VARCHAR(30), "+ _sFname+" VARCHAR(30), "+ _sMname +" VARCHAR(30)," +
                        " "+ _sLname+ " VARCHAR(30),"+ _sBday+" DATE,"+_sContact+" INTEGER, "+ _sEmail +" VARCHAR(30), "+_sCardNm+" VARCHAR(50), "+ _sPin+ " INTEGER(5)  );");
                //CREATE
                db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_CATEGORY+ " (Category_id INTEGER PRIMARY KEY AUTOINCREMENT, "+_sCategory+" VARCHAR(20), "+_sPct+" VARCHAR(20) )");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // _s = String _i = Integer _d = Double --- Variable Standard
    public void createAccount(String sUname, String sUpass, String sFname, String sMname, String sLname,String sBday, String sContact,String sEmail, String sCarnNm,  String sPin){
        try{
            //("+_sUname+", "+_sUpass+" , "+_sFname+", "+_sMname+", "+_sLname+" , "+_sEmail+" ," +"+_sCardNm+", "+_sPin+")
            db.execSQL("INSERT INTO  "+ TABLE_USER +"  VALUES (1, '"+sUname+"','"+sUpass+"','"+sFname+"', '"+sMname+"', '"+sLname+"', '"+sBday+"' , "+sContact+", '"+sEmail+"' , '"+sCarnNm+"', "+sPin+");");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void editAccount(String sUname, String sUpass, String sFname, String sMname, String sLname,String sBday, String sContact,String sEmail, String sCarnNm,  String sPin)
    {
        try {
            db.execSQL("UPDATE "+ TABLE_USER + " SET ('"+_sUname+"', '"+_sUpass+"' , '"+_sFname+"', '"+_sMname+"', '"+_sLname+"' , '"+_sBday+"', "+_sContact+",'"+_sEmail+"' ,'"+_sCardNm+"', "+_sPin+") " +
                    "= ('"+sUname+"','"+sUpass+"','"+sFname+"', '"+sMname+"', '"+sLname+"', '"+sBday+"' , "+sContact+", '"+sEmail+"' , '"+sCarnNm+"', "+sPin+") WHERE "+_sCardNm+"   = '"+sCarnNm+"' ");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public ArrayList<String> userInfo() {
        ArrayList<String> info = new ArrayList<>();
        try {
            int x =0;
            c = db.rawQuery("SELECT * FROM "+TABLE_USER+" WHERE  "+_sUid+"  = "+uID+";",null);
            while(c.moveToNext()){
                info.add(c.getString(1));//username
                info.add(c.getString(2));//pass
                info.add(c.getString(3));//firstname
                info.add(c.getString(4));//middlename
                info.add(c.getString(5));//lastname
                info.add(c.getString(6));//birthday
                info.add(c.getString(7));//contact
                info.add(c.getString(8));//email
                info.add(c.getString(10));//pin

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }
    public Boolean isRegistered(String uName, String uPass){
        try {
            int x =0;
            c = db.rawQuery("SELECT "+ _sUname + ", "+_sUpass+" , "+ _sUid+" FROM "+TABLE_USER+"  ;",null);
            while(c.moveToNext()){
                if(c.getString(0).equals(uName) && c.getString(1).equals(uPass)){
                    uID = c.getString(2);
                    return true;
                }else{
                    x++;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void addCategory(HashMap<String,Integer> userCategory){
        try {

            for(Map.Entry<String,Integer>  entry : userCategory.entrySet()){
                db.execSQL("INSERT "+TABLE_CATEGORY+" VALUES(1,'"+ entry.getKey() +"', "+entry.getValue()+")");
            }
//            c = db.rawQuery("SELECT "+ _sCategory + " FROM "+TABLE_CATEGORY+"  ;",null);

//            if(c.getCount() = 0){

//            }else{
//                for(Map.Entry<String, Integer> entry : userCategory.entrySet()){
//                    while(c.moveToNext()){
//                        if(entry.getKey().equals(c.getString(0))){
//
//                        }
//                    }
//                }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public HashMap<String,Integer> getCategory(){
        c = db.rawQuery("SELECT * FROM "+TABLE_CATEGORY+"  ;",null);
        HashMap<String,Integer> hashCat = new HashMap<>();
        while(c.moveToNext()){
            hashCat.put(c.getString(1), c.getInt(2));
        }
        return hashCat;

    }
    public String getUserEmail(){
        c = db.rawQuery("SELECT "+_sEmail+" FROM "+TABLE_CATEGORY+"  ;",null);
        while (c.moveToNext()){
            return c.getString(0);
        }
        return null;
    }


}
