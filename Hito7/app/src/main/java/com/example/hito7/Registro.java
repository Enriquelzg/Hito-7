package com.example.hito7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Registro extends AppCompatActivity {

    private TextView Login;
    private Button register;
    private EditText correo, contraseña, contraseña2;
    private String email, password;
    private FirebaseAuth mAuth;
    private DatabaseReference myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        Login = findViewById(R.id.login2);
        contraseña2 = findViewById(R.id.contraseña3);
        register = findViewById(R.id.register2);
        correo = findViewById(R.id.correo2);
        contraseña = findViewById(R.id.contraseña2);
        myDB = FirebaseDatabase.getInstance().getReference();
        email = correo.toString();
        password = contraseña.toString();

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                if (contraseña != null) {
                    startActivity(new Intent(Registro.this, Registro.class));
                }
            }
        });
    }
    public void crearAcount (String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Registro.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
}