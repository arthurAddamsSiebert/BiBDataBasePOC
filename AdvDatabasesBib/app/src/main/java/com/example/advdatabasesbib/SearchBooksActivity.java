package com.example.advdatabasesbib;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchBooksActivity extends AppCompatActivity {

    // booksList RecyclerView
    private RecyclerView booksList;
    BookAdapter BookAdapter;
    String titles[]={"Autonomes Fahren: Tesla und KI","Die Tribute von Panem","Harry Stotter 2.0"};
    String years[]={"2019","2011","2018"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);

        booksList = findViewById(R.id.book_list);
        booksList.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        booksList.setLayoutManager(layoutManager);

        ArrayList<String> list_of_titles = new ArrayList<>();
        list_of_titles.add(titles[0]);
        list_of_titles.add(titles[1]);
        list_of_titles.add(titles[2]);

        ArrayList<String> list_of_years = new ArrayList<>();
        list_of_years.add(years[0]);
        list_of_years.add(years[1]);
        list_of_years.add(years[2]);

        BookAdapter = new BookAdapter(list_of_titles, list_of_years, this);
        booksList.setAdapter(BookAdapter);
        booksList.getAdapter().notifyDataSetChanged();
    }

    public void searchBooksInList(View view) {
        // TODO: Liste nach angegebenen Parametern durchsuchen und nur passendes Item anzeigen
        Toast.makeText(this, "Die Liste wurde nach dem gewünschten Buch durchsucht.", Toast.LENGTH_SHORT).show();
    }

}
