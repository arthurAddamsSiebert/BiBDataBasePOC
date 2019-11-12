package com.example.advdatabasesbib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    // TODO: Objekte übergeben, sodass diese in der RecyclerView angezeigt werden
    // TODO: Wenn ein Item angeklickt wird, öffne den DetailScreen und übergebe die Werte des Objektes

    ArrayList<String> book_titles_list, book_years_list;
    Context context;

    public BookAdapter(ArrayList<String> tList, ArrayList<String> yList, Context context) {
        this.book_titles_list = tList;
        this.book_years_list = yList;
        this.context = context;
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.book_view, viewGroup, false);
        return new BookAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(book_titles_list.get(i));
        viewHolder.year.setText(book_years_list.get(i));
        viewHolder.image.setImageResource(R.drawable.books_icon);
    }

    @Override
    public int getItemCount() {
        return book_titles_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title, year;
        public LinearLayout linLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.book_view_pic);
            title = itemView.findViewById(R.id.book_view_title);
            year = itemView.findViewById(R.id.book_view_year);
            linLayout = itemView.findViewById(R.id.book_view_linLay);
        }
    }
    
}
