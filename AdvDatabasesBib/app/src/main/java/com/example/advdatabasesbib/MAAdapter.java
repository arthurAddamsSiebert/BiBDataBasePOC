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

public class MAAdapter extends RecyclerView.Adapter<MAAdapter.ViewHolder> {

    // TODO: Objekte übergeben, sodass diese in der RecyclerView angezeigt werden
    // TODO: Wenn ein Item angeklickt wird, öffne den DetailScreen und übergebe die Werte des Objektes

    ArrayList<String> ma_firstnames_list, ma_lastnames_list, mnr_list;
    Context context;

    public MAAdapter(ArrayList<String> fList, ArrayList<String> lList, ArrayList<String> mList, Context context) {
        this.ma_firstnames_list = fList;
        this.ma_lastnames_list = lList;
        this.mnr_list = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MAAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.ma_view, viewGroup, false);
        return new MAAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MAAdapter.ViewHolder viewHolder, int i) {
        viewHolder.firstname.setText(ma_firstnames_list.get(i));
        viewHolder.lastname.setText(ma_lastnames_list.get(i));
        viewHolder.mnr.setText(mnr_list.get(i));
        viewHolder.image.setImageResource(R.drawable.ma_avatar);
    }

    @Override
    public int getItemCount() {
        return ma_firstnames_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView firstname, lastname, mnr;
        public LinearLayout linLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.ma_view_pic);
            firstname = itemView.findViewById(R.id.ma_view_firstname);
            lastname = itemView.findViewById(R.id.ma_view_lastname);
            mnr = itemView.findViewById(R.id.ma_view_mnr);
            linLayout = itemView.findViewById(R.id.ma_view_linLay);
        }
    }
    
}
