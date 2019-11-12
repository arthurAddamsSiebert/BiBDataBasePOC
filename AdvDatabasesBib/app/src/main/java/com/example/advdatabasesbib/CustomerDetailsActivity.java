package com.example.advdatabasesbib;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomerDetailsActivity extends AppCompatActivity {

    EditText verleihBuchISBN;
    String verleihISBN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivty_customer_detail);

        verleihBuchISBN = findViewById(R.id.verleihen_book_isbn);
        verleihISBN = verleihBuchISBN.getText().toString();
    }

    public void buchVerleihen(View view) {
        Toast.makeText(this, "Das Buch mit der ISBN " + verleihISBN + " wurde verliehen.", Toast.LENGTH_SHORT).show();
    }

}
