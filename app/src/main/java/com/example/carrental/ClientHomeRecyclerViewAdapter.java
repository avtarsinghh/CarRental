package com.example.carrental;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ClientHomeRecyclerViewAdapter extends RecyclerView.Adapter<ClientHomeRecyclerViewAdapter.ViewHolder> {
    ArrayList<String> arrayList;
    Context context;
    LayoutInflater layoutInflater;

    public ClientHomeRecyclerViewAdapter(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.client_list_home_page, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(arrayList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                if (position == 0) {
                    intent = new Intent(context, ViewVehicleClient.class);
                    intent.putExtra("mode", "viewall");
                } else if (position == 1) {
                    intent = new Intent(context, SelectDates.class);
                } else if (position == 2) {
                    intent = new Intent(context, SelectDates.class);
                } else if (position == 3) {
                    intent = new Intent(context, ViewReservations.class);
                }
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvClientListItem);
        }
    }
}
