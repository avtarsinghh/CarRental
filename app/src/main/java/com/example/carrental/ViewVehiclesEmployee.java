package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ViewVehiclesEmployee extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    VehicleRepositry vehicleRepositry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_employee);
        recyclerView = findViewById(R.id.rvVehicleListEmployee);

        vehicleRepositry = VehicleRepositry.getInstance();

        VehicleListEmployeeRecyclerViewAdapter vehicleListEmployeeRecyclerViewAdapter = new VehicleListEmployeeRecyclerViewAdapter(this, vehicleRepositry.getVehicles());
        recyclerView.setAdapter(vehicleListEmployeeRecyclerViewAdapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
