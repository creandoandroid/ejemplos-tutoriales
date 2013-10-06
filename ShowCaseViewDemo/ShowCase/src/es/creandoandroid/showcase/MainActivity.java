package es.creandoandroid.showcase;

import android.app.Activity;
import android.os.Bundle;

import com.github.espiandev.showcaseview.ShowcaseView;

public class MainActivity extends Activity {
	
	ShowcaseView sv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ShowcaseView.ConfigOptions co = new ShowcaseView.ConfigOptions();
        co.hideOnClickOutside = false;
        co.fadeInDuration = 500;
        co.fadeOutDuration = 500;
        
        sv = ShowcaseView.insertShowcaseView(R.id.boton, this, "Tutorial", "Disfrute de la experiencia con esta aplicacion", co);
       
        

        
	}

}
