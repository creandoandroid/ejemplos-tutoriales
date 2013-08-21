package com.dam.soundpoolinstrumentos;

import java.io.IOException;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SoundPoolInstrumentosActivity extends Activity {

	int miAudioAlarm = -1;
	int miAudioExplosion = -1;
	int miAudioLaser = -1;
	SoundPool sP;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ejemplo_sound_pool);

		//Instancio el SoundPool
		sP = new SoundPool(20, AudioManager.STREAM_MUSIC, 0);

		//Instancio los botones
		Button btnAlarma = (Button) findViewById(R.id.btnAlarma);
		Button btnExplosion = (Button) findViewById(R.id.btnExplosion);
		Button btnLaser = (Button) findViewById(R.id.btnLaser);

		try {
			//El AssetManager manejara la reproduccion de los sonidos
			AssetManager assetManager = getAssets();
			
			//Cargo los sonidos
			AssetFileDescriptor sound1 = assetManager.openFd("alarm.ogg");
			miAudioAlarm = sP.load(sound1, 1);
			
			AssetFileDescriptor sound2 = assetManager.openFd("explosion.ogg");
			miAudioExplosion = sP.load(sound2, 1);
			
			AssetFileDescriptor sound3 = assetManager.openFd("laser.ogg");
			miAudioLaser = sP.load(sound3, 1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Escuchadores de los botones
		btnAlarma.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				sP.play(miAudioAlarm, 1.0f, 1.0f, 1, 0, 1);
			}
		});
		
		btnExplosion.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				sP.play(miAudioExplosion, 1.0f, 1.0f, 1, 0, 1);
			}
		});
		
		btnLaser.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				sP.play(miAudioLaser, 1.0f, 1.0f, 1, 0, 1);
			}
		});
	}
}
