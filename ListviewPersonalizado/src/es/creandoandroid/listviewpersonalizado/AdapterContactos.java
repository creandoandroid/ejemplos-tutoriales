package es.creandoandroid.listviewpersonalizado;

import java.util.ArrayList;

import es.creandoandroid.listviewpersonalizado.model.Contacto;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterContactos extends ArrayAdapter<Contacto> {
	
	Activity context;
	ArrayList<Contacto> listaContactos;
	
	// Le pasamos al constructor el contecto y la lista de contactos
	public AdapterContactos(Activity context, ArrayList<Contacto> listaContactos) {
		super(context, R.layout.layout_adapter, listaContactos);
		this.context = context;
		this.listaContactos = listaContactos;
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// Rescatamos cada item del listview y lo inflamos con nuestro layout
		View item = convertView;
		item = context.getLayoutInflater().inflate(R.layout.layout_adapter, null);
		
		Contacto c = listaContactos.get(position);
		
		// Definimos los elementos que tiene nuestro layout
		ImageView img = (ImageView)item.findViewById(R.id.imagen);
		TextView nombre = (TextView) item.findViewById(R.id.texto);
		
		img.setImageDrawable(context.getResources().getDrawable(c.getImagen()));
		nombre.setText(c.getNombre());
		
		return (item);
	}
	
}
