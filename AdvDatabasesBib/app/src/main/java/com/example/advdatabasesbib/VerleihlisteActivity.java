package com.example.advdatabasesbib;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VerleihlisteActivity extends AppCompatActivity {

    // verleihListe RecyclerView
    private RecyclerView verleihListe;
    VerleihlisteAdapter VerleihlisteAdapter;
    String titles[]={"Numero 1 beim Verleih - Das Buch","Ich bin ein verliehenes Buch","Der fliegende Audi"};
    String years[]={"1998","1902","1997"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleihliste);

        verleihListe = findViewById(R.id.verleihListe);
        verleihListe.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        verleihListe.setLayoutManager(layoutManager);

        ArrayList<String> list_of_titles = new ArrayList<>();
        list_of_titles.add(titles[0]);
        list_of_titles.add(titles[1]);
        list_of_titles.add(titles[2]);

        ArrayList<String> list_of_years = new ArrayList<>();
        list_of_years.add(years[0]);
        list_of_years.add(years[1]);
        list_of_years.add(years[2]);

        VerleihlisteAdapter = new VerleihlisteAdapter(list_of_titles, list_of_years, this);
        verleihListe.setAdapter(VerleihlisteAdapter);
        verleihListe.getAdapter().notifyDataSetChanged();
    }
    
}
