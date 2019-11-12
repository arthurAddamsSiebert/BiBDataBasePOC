package com.example.advdatabasesbib;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddCustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
    }

    public void addNewCustomer(View view) {
        // TODO: Neuen Kunden mit den eingegebenen Daten der DB hinzufügen, KID soll automatisch hochzählen
        Toast.makeText(this, "Neuer Kunde wurde hinzugefügt.", Toast.LENGTH_SHORT).show();
    }

}
