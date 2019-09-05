package com.example.provincia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edit_dni;
    Spinner spin_provincia;
    Spinner spin_distrito;
    Button siguiente;
    int e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_dni = findViewById(R.id.edit_dni);
        spin_provincia = findViewById(R.id.spin_provincia);
        spin_distrito = findViewById(R.id.spin_distrito);
        siguiente = findViewById(R.id.Siguiente);

        final String[] provincias = getResources().getStringArray(R.array.opciones_provincias);
        final String[] Arequipa = getResources().getStringArray(R.array.Arequipa);
        final String[] Camana = getResources().getStringArray(R.array.Camana);

        final ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,R.layout.provincia,provincias);
        final ArrayAdapter<String> adapter2 =  new ArrayAdapter<String>(this,R.layout.provincia,Arequipa);
        final ArrayAdapter<String> adapter3 =  new ArrayAdapter<String>(this,R.layout.provincia,Camana);

        spin_provincia.setAdapter(adapter);
        spin_provincia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    spin_distrito.setAdapter(adapter2);
                }

                if(i == 1){
                    spin_distrito.setAdapter(adapter3);
                }
                e=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("dni",edit_dni.getText().toString());
                intent.putExtra("Provincia",provincias[spin_provincia.getSelectedItemPosition()]);
                if(e==0){

                    intent.putExtra("Distrito",Arequipa[spin_distrito.getSelectedItemPosition()]);
                }

                if(e==1){

                    intent.putExtra("Distrito",Camana[spin_distrito.getSelectedItemPosition()]);
                }

                startActivity(intent);
            }
        });

    }
}
