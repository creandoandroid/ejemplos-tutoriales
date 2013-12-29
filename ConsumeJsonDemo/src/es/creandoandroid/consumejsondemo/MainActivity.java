package es.creandoandroid.consumejsondemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView buscarArtista, nombreArtista, descripcionArtista;
	Button buscar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		final ArtistaApi api = new ArtistaApi(getApplicationContext());

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buscarArtista = (TextView) findViewById(R.id.buscarArtista);
		nombreArtista = (TextView) findViewById(R.id.nombreArtista);
		descripcionArtista = (TextView) findViewById(R.id.descripcionArtista);
		buscar = (Button) findViewById(R.id.buscar);

		buscar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				final Artista artista = api.buscarArtista(buscarArtista.getText().toString());
				nombreArtista.setText(artista.getNombre());
				descripcionArtista.setText(artista.getDescripcion());
			}
		});

	}
}


