package es.creandoandroid.swiperefreshdemo;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements SwipeRefreshLayout.OnRefreshListener{

	private SwipeRefreshLayout swipeRefresh;
	private ListView listview;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> values;
	private SoundPool soundPool;
	private int soundID;
	private boolean loaded = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Nuevo Elemento: Swipe Refresh Layout
		swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
		swipeRefresh.setOnRefreshListener(this);
		swipeRefresh.setColorScheme(android.R.color.holo_blue_dark,
				android.R.color.holo_orange_light,
				android.R.color.holo_green_dark,
				android.R.color.holo_red_light);

		listview = (ListView) findViewById(R.id.listView);

		values = new ArrayList<String>();

		values.add("Elemento 1");
		values.add("Elemento 2");
		values.add("Elemento 3");
		values.add("Elemento 4");
		values.add("Elemento 5");
		values.add("Elemento 6");
		values.add("Elemento 7");
		values.add("Elemento 8");
		values.add("Elemento 9");
		values.add("Elemento 10");
		values.add("Elemento 11");

		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, values);
		listview.setAdapter(adapter);
		
		
		// Extra: sonido al actualizar con SwipeRefreshLayout
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		soundID = soundPool.load(this, R.raw.ping, 1);

		soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
			public void onLoadComplete(SoundPool soundPool, int sampleId,int status) {
				loaded = true;
			}
		});


	}

	@Override
	public void onRefresh() {
		
		// Reproduccion de sonido
		if (loaded) {
			soundPool.play(soundID,  0.9f, 0.9f, 1, 0, 1f);
		}
		new Handler().postDelayed(new Runnable() {
			@Override public void run() {
				values.add(0, "Elemento Nuevo");
				adapter.notifyDataSetChanged();

				// Finalizar swipeRefresh
				swipeRefresh.setRefreshing(false);
			}
		}, 2000);
	}


}
