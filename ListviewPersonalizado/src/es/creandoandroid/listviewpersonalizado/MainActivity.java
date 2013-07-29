package es.creandoandroid.listviewpersonalizado;

import java.util.ArrayList;

import es.creandoandroid.listviewpersonalizado.model.Contacto;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

public class MainActivity extends Activity {

	ListView listView;
	ArrayList<Contacto> listaContactos;
	
	// Creamos un adapter personalizado
	AdapterContactos adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView);
		listaContactos = new ArrayList<Contacto>();
		
		// Al adapter personalizado le pasamos el contexto y la lista que contiene
		// Añadimos el adapter al listview
		adapter = new AdapterContactos(this, listaContactos);
		listView.setAdapter(adapter);

		listaContactos.add(new Contacto(R.drawable.david, "David"));
		listaContactos.add(new Contacto(R.drawable.miguel, "Miguel"));

	}

}
