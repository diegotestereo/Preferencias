package com.example.preferencias;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {
	Button Btn_Ingresar;
	EditText user,password;
	public SharedPreferences preferencias;
	TextView Bandera;
	String Us,Pas;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        levantarXML();
        preferencias=getSharedPreferences("MisPref", Context.MODE_PRIVATE);
        botones();
      
    }
	
   	private void botones() {
   		
		Btn_Ingresar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("Boton Ingresar", "Se apreto boton");
				
				Us=user.getText().toString();
				Pas=password.getText().toString();
				
				if(validar(Us,Pas).equals("")){
					Log.d("validar", "usuario: "+Us+" password: "+Pas);
					
					SegundaActividad();
								}
					}
		});	
	}


	private void SegundaActividad(){
		Intent intento;
		intento= new Intent(MainActivity.this,SegundaActividad.class);
		startActivity(intento);
	};
		
	private String validar(String us,String pas) {
		
		String usuario,password;
		
		usuario=preferencias.getString("user", "default");
		Log.d("validar","user pref: "+usuario);
		password=preferencias.getString("pass", "default");
				
		if (usuario.equals("default")){
			AlmacenarPreferencias();
			usuario=preferencias.getString("user", "default");
			Log.d("validar","user pref almacenado: "+usuario);
		// almaceno preferencias y retorno validacion ok.
		return "";}
		
		if (!usuario.equals(us)){
			Log.d("validar","Error Usuario");
			return "Error Usuario";}
				
		Log.d("validar","ok!");
		return "";
		
	}


	private void levantarXML() {
		Btn_Ingresar=(Button) findViewById(R.id.Btn_Ingresar);
		user=(EditText) findViewById(R.id.Etxt_User);
		password=(EditText) findViewById(R.id.ETxt_Pass);
		Bandera=(TextView) findViewById(R.id.TxtV_Bandera);
		
	}

	
	private void AlmacenarPreferencias(){
		 
		  Log.d("validar","preferencias Almacenadas "+Us+"  "+Pas);
		SharedPreferences.Editor editor=preferencias.edit();
		editor.putString("user", Us);
		editor.putString("pass", Pas);
		editor.commit();
		Log.d("validar","preferencias Almacenadas "+Us+"  "+Pas);
		
		
	}

}
