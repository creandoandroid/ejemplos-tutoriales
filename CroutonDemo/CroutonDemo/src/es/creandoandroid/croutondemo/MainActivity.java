package es.creandoandroid.croutondemo;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class MainActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    setContentView(R.layout.activity_main);
	    
	    Button btn_info = (Button) findViewById(R.id.btn_info);
	    Button btn_confirm = (Button) findViewById(R.id.btn_confirm);
	    Button btn_alert = (Button) findViewById(R.id.btn_alert);
	    Button btn_custom = (Button) findViewById(R.id.btn_custom);
	    
	    btn_info.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Crouton.makeText(MainActivity.this, "Crouton Info", Style.INFO).show();
			}
		});
	    
	    btn_confirm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Crouton.makeText(MainActivity.this, "Crouton Confirm", Style.CONFIRM).show();
			}
		});
	    
	    btn_alert.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Crouton.makeText(MainActivity.this, "Crouton Alert", Style.ALERT).show();
			}
		});
	    
	    btn_custom.setOnClickListener(new OnClickListener() {
			@SuppressLint("ResourceAsColor")
			@Override
			public void onClick(View v) {
				Style custom = new Style.Builder()
				.setWidth(500)
				.setGravity(Gravity.LEFT)
				.setBackgroundColor(android.R.color.black).build();
				
				Crouton.makeText(MainActivity.this, "Crouton Personalizado", custom).show();
			}
		});
	}

	@Override
	protected void onDestroy() {
		Crouton.cancelAllCroutons();
	}
	
	

}
