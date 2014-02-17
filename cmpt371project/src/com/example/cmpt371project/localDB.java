package com.example.cmpt371project;

import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class localDB extends SQLiteOpenHelper{
    private final static String DATABASE_NAME = "localDB";  
    private final static int DATABASE_VERSION = 1;  
    private final static String TABLE_NAME = "userData";  
    public final static String USER_ID = "user_ID";  
    public final static String USER_PASSWORD = "user_Passowrd";  

	
	public localDB(Context context) {
		super(context,DATABASE_NAME,null,DATABASE_VERSION);	
		System.out.println("oncreat");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("DB start");
		System.out.println(" in oncreat");
		String sql = "CREATE TABLE "+TABLE_NAME+" ("
				+USER_ID +" TEXT, "
				+USER_PASSWORD+ " TEXT);";
				db.execSQL(sql);
				System.out.println("DB created");
				
		//temp
		 ContentValues childIn = new ContentValues();
		           
		 childIn.put(USER_ID, "admin");
		 childIn.put(USER_PASSWORD, "admin");  
		 
		 db.insert(TABLE_NAME, null, childIn);  
			System.out.println("finish on create");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println("DB upgrade");
		String sql = "DROP TABLE IF EXISTS " + TABLE_NAME; 
		db.execSQL(sql);
		onCreate(db);
		
	}
	
	public String readPassword(String username){
		//to do 
		//the password need to be encrypt
		System.out.println("enter readpassword");
		String password = new String();
		Cursor DBcursor = this.getWritableDatabase().rawQuery("Select user_Passowrd from userData WHERE user_ID='" + username + "'",null);
		
    	while(DBcursor.moveToNext()){	
    		password = DBcursor.getString(0);	
    	}
    	DBcursor.close(); 
    	this.getWritableDatabase().close();
    	System.out.println("finish readpassword");
		return password;
	}
//	public void initialize(){
//		 SQLiteDatabase db = this.getWritableDatabase();  
//	}
}
