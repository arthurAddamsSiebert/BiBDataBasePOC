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

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {

    // TODO: Objekte übergeben, sodass diese in der RecyclerView angezeigt werden
    // TODO: Wenn ein Item angeklickt wird, öffne den DetailScreen und übergebe die Werte des Objektes

    ArrayList<String> firstnames_list, lastnames_list, kids_list;
    Context context;

    public CustomerAdapter(ArrayList<String> fList, ArrayList<String> lList, ArrayList<String> kList, Context context) {
        this.firstnames_list = fList;
        this.lastnames_list = lList;
        this.kids_list = kList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.customer_view, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.firstname.setText(firstnames_list.get(i));
        viewHolder.lastname.setText(lastnames_list.get(i));
        viewHolder.kid.setText(kids_list.get(i));
        viewHolder.image.setImageResource(R.drawable.customer_avatar);
    }

    @Override
    public int getItemCount() {
        return firstnames_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView firstname, lastname, kid;
        public LinearLayout linLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.customer_view_pic);
            firstname = itemView.findViewById(R.id.customer_view_firstname);
            lastname = itemView.findViewById(R.id.customer_view_lastname);
            kid = itemView.findViewById(R.id.customer_view_kid);
            linLayout = itemView.findViewById(R.id.customer_view_linLay);
        }
    }

}
