package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class EmployeeHome extends AppCompatActivity {

    ArrayList<String> arrayList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);
        recyclerView = findViewById(R.id.employeeRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        arrayList = new ArrayList<>();
        arrayList.add("Add new Customer");
        arrayList.add("View all customers");
        arrayList.add("View Vehicles");
        arrayList.add("View Reservations");
        arrayList.add("Add new Vehicle");

        EmployeeHomeRecyclerViewAdapter recyclerViewAdapter = new EmployeeHomeRecyclerViewAdapter(this, arrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
