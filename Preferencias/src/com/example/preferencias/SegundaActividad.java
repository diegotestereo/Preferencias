package com.example.preferencias;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SegundaActividad extends Activity{
	Button Btn_BorrarPref;
	TextView TxtV_User;
	public SharedPreferences preferencias;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segunda_actividad);
		levantarXML();
		cargarpreferencias();
		
	}

	private void cargarpreferencias() {
		preferencias=getSharedPreferences("MisPref", MODE_PRIVATE);
		TxtV_User.setText(preferencias.getString("user", "defaults"));
	}

	private void levantarXML() {
	Btn_BorrarPref=(Button) findViewById(R.id.Btn_BorrarPref);
	TxtV_User=(TextView) findViewById(R.id.TxtView_User);
	}

}
