package com.example.carrental;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

public class VehicleListRecyclerViewAdapter extends RecyclerView.Adapter<VehicleListRecyclerViewAdapter.ViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    Map<String, Vehicle> vehicleMap;
    ArrayList<String> licenceNumbers;

    public VehicleListRecyclerViewAdapter(Context context, Map<String, Vehicle> vehicleMap){
        this.context = context;
        this.vehicleMap = vehicleMap;
        layoutInflater = LayoutInflater.from(context);
        licenceNumbers = new ArrayList<>(vehicleMap.keySet());
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

        holder.btnViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CarsDetails.class);
                intent.putExtra("plateNumber", license);
                context.startActivity(intent);
            }
        });

        holder.btnRentNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RentNow.class);
                intent.putExtra("plateNumber", license);
                context.startActivity(intent);
            }
        });

        holder.btnReserveNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ReserveNow.class);
                intent.putExtra("plateNumber", license);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vehicleMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBrand, tvModel;
        Button btnViewDetail, btnReserveNow, btnRentNow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBrand = itemView.findViewById(R.id.tvBrandVehicleList);
            tvModel = itemView.findViewById(R.id.tvModelVehicleList);
            btnViewDetail = itemView.findViewById(R.id.btnViewDetailVehicleList);
            btnReserveNow = itemView.findViewById(R.id.btnReserveNowVehicleList);
            btnRentNow = itemView.findViewById(R.id.btnRentNowVehicleList);
        }
    }
}
