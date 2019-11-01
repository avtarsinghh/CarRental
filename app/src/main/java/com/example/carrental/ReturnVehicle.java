package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class ReturnVehicle extends AppCompatActivity {
    Intent intent;
    String user, key;
    Button btnReturn;
    EditText etDate;
    TransactionRepository transactionRepository ;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_vehicle);
        intent = getIntent();
        user = intent.getStringExtra("user");
        key = intent.getStringExtra("key");
        btnReturn = findViewById(R.id.btnReturnVehicle);
        etDate = findViewById(R.id.etReturnDate);

        transactionRepository = TransactionRepository.getInstance();
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etDate.getText().toString();
                if(!date.equals("")){
                    Transaction transaction = transactionRepository.getTransactions().get(key.toLowerCase());
                    transaction.returnDate = date;
                    transactionRepository.setTransaction(transaction);
                    Intent intent = new Intent(ReturnVehicle.this, ViewReservations.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }
                else
                    Toast.makeText(ReturnVehicle.this, "Please enter date", Toast.LENGTH_LONG).show();
            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ReturnVehicle.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth, dateSetListener, year, month, day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                String date = day + "/" + month + "/" + year;
                etDate.setText(date);
            }
        };
    }
}
