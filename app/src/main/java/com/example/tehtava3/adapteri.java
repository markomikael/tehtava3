package com.example.tehtava3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class adapteri extends ArrayAdapter <Date> {


    private  Context context;
    ArrayList <Date> dataset;
    private Button poista;


    public adapteri(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        this.context = context;
        this.dataset = (ArrayList<Date>)objects;



    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.omalayout,parent,false);
        LinearLayout linearLayout = (LinearLayout) v;

        TextView lista = v.findViewById(R.id.lista);
        lista.setText(dataset.get(position).toString());

        Button poista = v.findViewById(R.id.poista);

        poista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.remove(position);
                notifyDataSetChanged();

            }
        });

        return v;
    }
}







