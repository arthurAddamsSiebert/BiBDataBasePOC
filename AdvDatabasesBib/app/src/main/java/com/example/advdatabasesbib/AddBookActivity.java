package com.example.advdatabasesbib;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
    }

    public void addNewBook(View view) {
        // TODO: Füge ein neues Buch mit den eingegebenen Daten der DB hinzu
        Toast.makeText(this, "Das Buch wurde dem Bestand hinzugefügt.", Toast.LENGTH_SHORT).show();
    }

}
