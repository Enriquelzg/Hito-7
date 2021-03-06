package com.example.hito7;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class LeerEscribir {
    private static final String TAG = "ReadAndWriteSnippets";

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    public LeerEscribir(DatabaseReference database) {
        // [START initialize_database_ref]
        mDatabase = FirebaseDatabase.getInstance("https://hito-7-default-rtdb.europe-west1.firebasedatabase.app/").getReference();
        // [END initialize_database_ref]
    }

    // [START rtdb_write_new_user]
    public void writeNewUser(String password, String email) {
        User user = new User(email, password);
        mDatabase.child("users").child(email).setValue(user);
    }

    public void borrar (){
        mDatabase.child("users").setValue(null);
    }

}
