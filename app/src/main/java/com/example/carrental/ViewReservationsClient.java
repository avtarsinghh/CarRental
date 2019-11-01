package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewReservationsClient extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView.LayoutManager layoutManager;
TransactionRepository transactionRepository;
Map<String, Transaction> transactionMap;
ArrayList<String> arrayList;
String user;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reservations);
        recyclerView = findViewById(R.id.rvReservationView);
        layoutManager = new LinearLayoutManager(this);
        transactionRepository = TransactionRepository.getInstance();
        transactionMap = new HashMap<>();
        arrayList = new ArrayList<>(transactionRepository.getTransactions().keySet());
        intent = getIntent();
        user = intent.getStringExtra("user");

        for(int i = 0; i<arrayList.size(); i++){
            Transaction transaction = transactionRepository.getTransactions().get(arrayList.get(i));
            Transaction transaction1 = transactionRepository.getTransactions().get(user.toLowerCase()+transaction.vehicle.licencePlate.toLowerCase());
            if(transaction1 != null)
                transactionMap.put(user.toLowerCase()+transaction.vehicle.licencePlate.toLowerCase(), transaction1);
        }

        ViewReservationsRecyclerViewAdapterClient viewReservationsRecyclerViewAdapterClient =
                new ViewReservationsRecyclerViewAdapterClient(this, transactionMap, user);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(viewReservationsRecyclerViewAdapterClient);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ClientHome.class);
        startActivity(intent);
        this.finish();
    }
}
