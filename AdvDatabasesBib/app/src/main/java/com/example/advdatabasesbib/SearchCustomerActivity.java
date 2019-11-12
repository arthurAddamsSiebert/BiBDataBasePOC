package com.example.advdatabasesbib;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchCustomerActivity extends AppCompatActivity {

    // customerList RecyclerView
    private RecyclerView customerList;
    CustomerAdapter customerAdapter;
    String firstnames[]={"Arthur","Dennis","Mohammad Ali"};
    String lastnames[]={"Siebert","Neumann","Alnaser"};
    String kids[]={"0","1","2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_customer);

        customerList = findViewById(R.id.customer_list);
        customerList.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        customerList.setLayoutManager(layoutManager);

        ArrayList<String> list_of_firstnames = new ArrayList<>();
        list_of_firstnames.add(firstnames[0]);
        list_of_firstnames.add(firstnames[1]);
        list_of_firstnames.add(firstnames[2]);

        ArrayList<String> list_of_lastnames = new ArrayList<>();
        list_of_lastnames.add(lastnames[0]);
        list_of_lastnames.add(lastnames[1]);
        list_of_lastnames.add(lastnames[2]);

        ArrayList<String> list_of_kids = new ArrayList<>();
        list_of_kids.add(kids[0]);
        list_of_kids.add(kids[1]);
        list_of_kids.add(kids[2]);

        customerAdapter = new CustomerAdapter(list_of_firstnames, list_of_lastnames, list_of_kids, this);
        customerList.setAdapter(customerAdapter);
        customerList.getAdapter().notifyDataSetChanged();
    }

    public void searchCustomerInList(View view) {
        // TODO: Liste nach angegebenen Parametern durchsuchen und nur passendes Item anzeigen
        Toast.makeText(this, "Die Liste wurde nach dem gewünschten Kunden durchsucht.", Toast.LENGTH_SHORT).show();
    }

}
