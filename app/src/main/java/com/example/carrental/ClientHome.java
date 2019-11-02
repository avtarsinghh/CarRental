package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ClientHome extends AppCompatActivity {
    ArrayList<String> arrayList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Intent intent;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_home);

        intent = getIntent();
        user = intent.getStringExtra("user");
        recyclerView = findViewById(R.id.clientRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        arrayList = new ArrayList<>();
        arrayList.add("View all vehicles");
        arrayList.add("Vehicle's between two dates");
        arrayList.add("Rent vehicle now");
        arrayList.add("View Reservations");

        ClientHomeRecyclerViewAdapter recyclerViewAdapter = new ClientHomeRecyclerViewAdapter(this, arrayList, user);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
