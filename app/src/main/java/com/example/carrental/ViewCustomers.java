package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ViewCustomers extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomerListRecyclerViewAdapter customerListRecyclerViewAdapter;
    UserRepository userRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer);
        recyclerView = findViewById(R.id.rvCustomerList);
        userRepository = UserRepository.getInstance();
        customerListRecyclerViewAdapter = new CustomerListRecyclerViewAdapter(this, userRepository.getUsers());
        recyclerView.setAdapter(customerListRecyclerViewAdapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
