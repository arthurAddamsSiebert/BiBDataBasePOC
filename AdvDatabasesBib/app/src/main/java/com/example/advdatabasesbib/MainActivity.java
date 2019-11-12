package com.example.advdatabasesbib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mnr, pwd;
    Button login_btn;
    Boolean exists = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mnr = findViewById(R.id.mnr);
        pwd = findViewById(R.id.passwort);
        login_btn = findViewById(R.id.login_btn);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {

        // TODO: Prüfen, ob Mitarbeiter existiert

        if(exists) {
            // TODO: Wenn ja, öffne Options Activity
            Intent i = new Intent(MainActivity.this, OptionsActivity.class);
            startActivity(i);
            finish();
        } else {
            // TODO: Wenn nein, sag dem Benutzer dass seine Login-Daten falsch sind
            Toast.makeText(this, "Leider war der Login nicht erfolgreich", Toast.LENGTH_LONG).show();
        }

    }

}
