package com.example.hito7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {

    private TextView Login;
    private Button Log, register;
    private EditText correo, contraseña;
    private DatabaseReference myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = findViewById(R.id.login);
        Log = findViewById(R.id.boton);
        register = findViewById(R.id.register);
        correo = findViewById(R.id.correo);
        contraseña = findViewById(R.id.contraseña);

        Log.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                startActivity(new Intent(MainActivity.this, Aplicacion.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                startActivity(new Intent(MainActivity.this, Registro.class));
            }
        });
    }
}