package com.example.advdatabasesbib;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchMAActivity extends AppCompatActivity {

    // maList RecyclerView
    private RecyclerView maList;
    MAAdapter MAAdapter;
    String firstnames[]={"Günther","Olaf","Jesus"};
    String lastnames[]={"Müller","Hasel","Klausen"};
    String mnr[]={"3556","3557","3558"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ma);

        maList = findViewById(R.id.ma_list);
        maList.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        maList.setLayoutManager(layoutManager);

        ArrayList<String> list_of_firstnames = new ArrayList<>();
        list_of_firstnames.add(firstnames[0]);
        list_of_firstnames.add(firstnames[1]);
        list_of_firstnames.add(firstnames[2]);

        ArrayList<String> list_of_lastnames = new ArrayList<>();
        list_of_lastnames.add(lastnames[0]);
        list_of_lastnames.add(lastnames[1]);
        list_of_lastnames.add(lastnames[2]);

        ArrayList<String> list_of_mnr = new ArrayList<>();
        list_of_mnr.add(mnr[0]);
        list_of_mnr.add(mnr[1]);
        list_of_mnr.add(mnr[2]);

        MAAdapter = new MAAdapter(list_of_firstnames, list_of_lastnames, list_of_mnr, this);
        maList.setAdapter(MAAdapter);
        maList.getAdapter().notifyDataSetChanged();
    }

    public void searchMAInList(View view) {
        // TODO: Liste nach angegebenen Parametern durchsuchen und nur passendes Item anzeigen
        Toast.makeText(this, "Die Liste wurde nach dem gewünschten Mitarbeiter durchsucht.", Toast.LENGTH_SHORT).show();
    }

}
