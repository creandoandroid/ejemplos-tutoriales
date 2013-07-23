package com.example.auto_login;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
	}

	//Menu de opciones
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_welcome, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		//Boton de cerrar sesión
		case R.id.closessesion:
			//Borramos el usuario almacenado en preferencias y volvemos a la pantalla de login
			SharedPreferences settings = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
			SharedPreferences.Editor editor = settings.edit();
			editor.putString("name", "");
			editor.putString("pass", "");

			//Confirmamos el almacenamiento.
			editor.commit();
			
			//Volvemos a la pantalla de Login
			Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
			break;

		}
		return super.onOptionsItemSelected(item);
	}

}
