package es.creandoandroid.promptconuserdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView etiquetaNombre;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etiquetaNombre = (TextView) findViewById(R.id.nombre);

		// Rescatamos el layout creado para el prompt
		LayoutInflater li = LayoutInflater.from(this);
		View prompt = li.inflate(R.layout.prompt, null);

		// Creamos un constructor de Alert Dialog y le añadimos nuestro layout al cuadro de dialogo
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setView(prompt);

		final EditText nombreUsuario = (EditText) prompt.findViewById(R.id.nombre_usuario);

		// Mostramos el mensaje del cuadro de dialogo
		alertDialogBuilder
		.setCancelable(false)
		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				// Rescatamos el nombre del EditText y lo mostramos por pantalla
				etiquetaNombre.setText("Hola "+nombreUsuario.getText());
			}
		})
		.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
				// Cancelamos el cuadro de dialogo
				dialog.cancel();
			}
		});

		// Creamos un AlertDialog y lo mostramos
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}


}
