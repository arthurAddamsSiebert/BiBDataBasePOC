package com.example.advdatabasesbib;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddMAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mitarbeiter);
    }

    public void addNewMA(View view) {
        // TODO: Neuen Mitarbeiter mit den eingegebenen Daten der DB hinzufügen, MNR soll automatisch hochzählen
        Toast.makeText(this, "Neuer Mitarbeiter wurde hinzugefügt.", Toast.LENGTH_SHORT).show();
    }

}
