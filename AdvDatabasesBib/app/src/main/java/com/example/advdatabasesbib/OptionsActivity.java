package com.example.advdatabasesbib;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void searchMA(View view) {
        Intent i = new Intent(OptionsActivity.this, SearchMAActivity.class);
        startActivity(i);
    }

    public void addMA(View view) {
        Intent i = new Intent(OptionsActivity.this, AddMAActivity.class);
        startActivity(i);
    }

    public void searchCustomer(View view) {
        Intent i = new Intent(OptionsActivity.this, SearchCustomerActivity.class);
        startActivity(i);
    }

    public void addCustomer(View view) {
        Intent i = new Intent(OptionsActivity.this, AddCustomerActivity.class);
        startActivity(i);
    }

    public void searchBooks(View view) {
        Intent i = new Intent(OptionsActivity.this, SearchBooksActivity.class);
        startActivity(i);
    }

    public void addBooks(View view) {
        Intent i = new Intent(OptionsActivity.this, AddBookActivity.class);
        startActivity(i);
    }

    public void showVerleihliste(View view) {
        Intent i = new Intent(OptionsActivity.this, VerleihlisteActivity.class);
        startActivity(i);
    }

    public void logout(View view) {
        // TODO: Mitarbeiter ausloggen
        Toast.makeText(this, "Logout erfolgreich.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

}
