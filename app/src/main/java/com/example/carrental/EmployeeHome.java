package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class EmployeeHome extends AppCompatActivity {

    ArrayList<String> arrayList2;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);
        recyclerView = findViewById(R.id.clientRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add("View all customers");
        arrayList.add("View list of vehicles");
        arrayList.add("View Reservations");

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, arrayList2);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
