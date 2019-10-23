package com.example.carrental;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeHomeRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeHomeRecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<String> arrayList;
    LayoutInflater layoutInflater;
    public EmployeeHomeRecyclerViewAdapter(Context context, ArrayList<String> arrayList){
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.employee_list_home_page, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tvEmployeeListItem);
        }
    }
}
