package com.example.hito7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private static final Object TAG = "Hola";
    private TextView Login;
    private Button Log, register, borrar;
    private EditText correo, contraseña;
    private FirebaseDatabase myDB = FirebaseDatabase.getInstance();
    private FirebaseAuth mAuth;
    private String email, password;
    private DatabaseReference mDataRef = myDB.getReference();
    private LeerEscribir database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        borrar = findViewById(R.id.eliminar);
        mAuth = FirebaseAuth.getInstance();
        Login = findViewById(R.id.login);
        Log = findViewById(R.id.boton);
        register = findViewById(R.id.register);
        correo = findViewById(R.id.correo);
        contraseña = findViewById(R.id.contraseña);
        database = new LeerEscribir(mDataRef);

        Log.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                email = correo.getText().toString();
                password = contraseña.getText().toString();
                signIN(email,password);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                startActivity(new Intent(MainActivity.this, Registro.class));
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.borrar();
            }
        });
    }


    public void signIN (String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            startActivity(new Intent(MainActivity.this, Aplicacion.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            //toast
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    public void updateUI (FirebaseUser user){}
}