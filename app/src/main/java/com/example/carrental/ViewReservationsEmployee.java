package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewReservationsEmployee extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    TransactionRepository transactionRepository;
    Map<String, Transaction> transactionMap;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reservations);

        recyclerView = findViewById(R.id.rvReservationView);
        layoutManager = new LinearLayoutManager(this);
        transactionRepository = TransactionRepository.getInstance();
        transactionMap = TransactionRepository.getInstance().getTransactions();


        ViewReservationsRecyclerViewAdapterEmployee viewReservationsRecyclerViewAdapterEmployee =
                new ViewReservationsRecyclerViewAdapterEmployee(this, transactionMap);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(viewReservationsRecyclerViewAdapterEmployee);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, EmployeeHome.class);
        startActivity(intent);
        this.finish();
    }
}
