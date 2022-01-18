package com.example.hito7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Registro extends AppCompatActivity {

    private TextView Login;
    private Button register;
    private EditText correo, contraseña, contraseña2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Login = findViewById(R.id.login2);
        contraseña2 = findViewById(R.id.contraseña3);
        register = findViewById(R.id.register2);
        correo = findViewById(R.id.correo2);
        contraseña = findViewById(R.id.contraseña2);

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                if (contraseña == contraseña2) {
                    startActivity(new Intent(Registro.this, Registro.class));
                }
            }
        });
    }
}