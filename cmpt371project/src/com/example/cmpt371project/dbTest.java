package com.example.cmpt371project;

import android.app.Activity;
import android.os.Bundle;

public class dbTest extends Activity{
	localDB testDB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		testDB = new localDB(this);
		testModify();
	}
	
	public void testModify(){
		System.out.println(testDB.readPassword("admin"));
	}
}
