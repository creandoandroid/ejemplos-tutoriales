package com.example.auto_login;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	//Estaticos
	static String NAME = "admin";
	static String PASS = "1234";
	
	//Elementos layout
	EditText editName;
	EditText editPass;
	Button btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Recuperamos los elementos del layout
		editName = (EditText) findViewById(R.id.editText1);
		editPass = (EditText) findViewById(R.id.editText2);
		btnLogin = (Button) findViewById(R.id.button1);
		
		//Recuperamos las preferencias almacenadas
		SharedPreferences prefs = getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
		String name = prefs.getString("name", "");
		String pass = prefs.getString("pass", "");
		
		//Comprobamos nombre y clave de ususario
		if(name.equals(NAME) && pass.equals(PASS)){
			
			//Si el usuario almacenado es correcto, entramos en la app
			Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
			startActivity(intent);
		}
		
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(editName.getText().toString().equals(NAME) && editPass.getText().toString().equals(PASS)){
					//Si el usuario escrito es correcto, almacenamos la preferencia y entramos en la app
					SharedPreferences settings = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
					SharedPreferences.Editor editor = settings.edit();
					editor.putString("name", editName.getText().toString());
					editor.putString("pass", editPass.getText().toString());
					
					//Confirmamos el almacenamiento.
					editor.commit();
					
					//Entramos en la app
					Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
					startActivity(intent);
					finish();
				}else{
					Toast.makeText(getApplicationContext(), "El usuario introducido no es correcto", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

}
