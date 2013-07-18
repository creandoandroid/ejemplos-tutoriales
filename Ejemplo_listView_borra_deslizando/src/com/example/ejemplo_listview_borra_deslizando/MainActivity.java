package com.example.ejemplo_listview_borra_deslizando;

import java.util.ArrayList;

import com.example.ejemplo_listview_borra_deslizando.SwipeListViewTouchListener;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	/*
	 *  Declaramos el listView del layout, el arraylist donde almacenaremos
	 *  todos los item que mostrará el listView y el adaptador necesario
	 *  para enlazar estos dos elementos
	 */

	ListView listView;
	ArrayList<String> arrayList = new ArrayList<String>();
	ArrayAdapter<String> adaptador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Instanciamos el listView
		listView = (ListView) findViewById(R.id.listView1);

		//Almacenamos los items en el arraylist
		arrayList.add("Objeto 1");
		arrayList.add("Objeto 2");
		arrayList.add("Objeto 3");
		arrayList.add("Objeto 4");
		arrayList.add("Objeto 5");
		arrayList.add("Objeto 6");
		arrayList.add("Objeto 7");
		arrayList.add("Objeto 8");
		arrayList.add("Objeto 9");
		arrayList.add("Objeto 10");

		//Instanciamos el adaptador, le pasamos el arraylist y al listview la pasamos nuestro adapter como adaptador de contenido
		adaptador = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(adaptador);

		//Deslizar item para borrarlo
		SwipeListViewTouchListener touchListener =new SwipeListViewTouchListener(listView,new SwipeListViewTouchListener.OnSwipeCallback() {
			@Override
			public void onSwipeLeft(ListView listView, int [] reverseSortedPositions) {
				//Aqui ponemos lo que hara el programa cuando deslizamos un item ha la izquierda
				arrayList.remove(reverseSortedPositions[0]);
				adaptador.notifyDataSetChanged();
			}

			@Override
			public void onSwipeRight(ListView listView, int [] reverseSortedPositions) {
				//Aqui ponemos lo que hara el programa cuando deslizamos un item ha la derecha
				arrayList.remove(reverseSortedPositions[0]);
				adaptador.notifyDataSetChanged();
			}
		},true, false);
		
		//Escuchadores del listView
		listView.setOnTouchListener(touchListener);
		listView.setOnScrollListener(touchListener.makeScrollListener());
	}

}
