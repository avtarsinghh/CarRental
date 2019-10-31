package com.example.carrental;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

public class VehicleListClientRecyclerViewAdapter extends RecyclerView.Adapter<VehicleListClientRecyclerViewAdapter.ViewHolder> {

    LayoutInflater layoutInflater;
    Context context;
    Map<String, Vehicle> vehicleMap;
    ArrayList<String> licenceNumbers;
    String mode;

    public VehicleListClientRecyclerViewAdapter(Context context, Map<String, Vehicle> vehicleMap, String mode){
        this.context = context;
        this.vehicleMap = vehicleMap;
        layoutInflater = LayoutInflater.from(context);
        licenceNumbers = new ArrayList<>(vehicleMap.keySet());
        this.mode = mode;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.vehicle_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final String license = licenceNumbers.get(position);
        holder.tvBrand.setText(vehicleMap.get(license).brand);
        holder.tvModel.setText(vehicleMap.get(license).model);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewVehicleDetailClient.class);
                intent.putExtra("mode", mode);
                intent.putExtra("license", license);
                context.startActivity(intent);
            }
        });

        String brand = vehicleMap.get(license).brand.toLowerCase();
        switch (brand) {
            case "audi":
                holder.imageView.setImageResource(R.drawable.audi);
                break;
            case "bmw":
                holder.imageView.setImageResource(R.drawable.bmw);
                break;
            case "ford":
                holder.imageView.setImageResource(R.drawable.ford);
                break;
            case "honda":
                holder.imageView.setImageResource(R.drawable.honda);
                break;
            case "hyundai":
                holder.imageView.setImageResource(R.drawable.hyundai);
                break;
            case "kia":
                holder.imageView.setImageResource(R.drawable.kia);
                break;
            case "mazda":
                holder.imageView.setImageResource(R.drawable.mazda);
                break;
            case "mercedes":
                holder.imageView.setImageResource(R.drawable.mercedes);
                break;
            case "nissan":
                holder.imageView.setImageResource(R.drawable.nissan);
                break;
            case "porsche":
                holder.imageView.setImageResource(R.drawable.porsche);
                break;
            case "subaru":
                holder.imageView.setImageResource(R.drawable.subaru);
                break;
            case "toyota":
                holder.imageView.setImageResource(R.drawable.audi);
                break;
            case "volkswagen":
                holder.imageView.setImageResource(R.drawable.audi);
                break;
            case "volvo":
                holder.imageView.setImageResource(R.drawable.audi);
                break;
            default:
                holder.imageView.setImageResource(android.R.drawable.stat_notify_error);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return vehicleMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBrand, tvModel;
        LinearLayout linearLayout;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBrand = itemView.findViewById(R.id.tvBrandVehicleList);
            tvModel = itemView.findViewById(R.id.tvModelVehicleList);
            linearLayout = itemView.findViewById(R.id.llVehicleList);
            imageView = itemView.findViewById(R.id.ivVehicleList);
        }
    }
}
