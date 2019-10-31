package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class ViewVehicleClient extends AppCompatActivity {
    Intent intent;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    VehicleRepositry vehicleRepositry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_client);

        intent = getIntent();
        String mode = intent.getStringExtra("mode");
        if(mode == null) mode = "";

        recyclerView = findViewById(R.id.rvVehicleListClient);

        vehicleRepositry = VehicleRepositry.getInstance();

        VehicleListClientRecyclerViewAdapter vehicleListEmployeeRecyclerViewAdapter = new VehicleListClientRecyclerViewAdapter(this, vehicleRepositry.getVehicles(), mode);
        recyclerView.setAdapter(vehicleListEmployeeRecyclerViewAdapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
