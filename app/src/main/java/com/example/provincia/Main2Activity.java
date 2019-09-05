package com.example.provincia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView txt_dni;
    TextView txt_provincia;
    TextView txt_distrito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt_dni = findViewById(R.id.txt_dni);
        txt_provincia = findViewById(R.id.txt_provincia);
        txt_distrito = findViewById(R.id.txt_distrito);

        Intent intent = getIntent();
        String dni = intent.getStringExtra("dni");
        txt_dni.setText(dni);

        String provincia = intent.getStringExtra("Provincia");
        txt_provincia.setText(provincia);

        String distrito = intent.getStringExtra("Distrito");
        txt_distrito.setText(distrito);
    }
}
