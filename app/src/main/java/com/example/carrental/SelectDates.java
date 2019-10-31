package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SelectDates extends AppCompatActivity {
    Intent intent;
    private EditText edtStartDate, edtEndDate;
    Button btnGo;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private DatePickerDialog.OnDateSetListener dateSetListener2;

    VehicleRepositry vehicleRepositry;
    UserRepository userRepository;
    TransactionRepository transactionRepository;
    String mode, license, startDate, endDate;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dates);

        edtStartDate = findViewById(R.id.edtStartDateSelectDate);
        edtEndDate = findViewById(R.id.edtEndDateSelectDate);
        btnGo = findViewById(R.id.btnGoSelectDates);
        vehicleRepositry = VehicleRepositry.getInstance();
        userRepository = UserRepository.getInstance();
        transactionRepository = TransactionRepository.getInstance();
        intent = getIntent();
        user = intent.getStringExtra("user");
        if (intent != null) {
            mode = intent.getStringExtra("mode");
            if (mode != null && !mode.equals("")) {
                if (mode.equalsIgnoreCase("rent")) {
                    Date c = Calendar.getInstance().getTime();

                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    startDate = df.format(c);
                    edtStartDate.setText(startDate);
                    edtStartDate.setEnabled(false);
                    license = intent.getStringExtra("license");
                }
            }
        }

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startDate != null && endDate != null && !startDate.equals("") && !endDate.equals("")) {
                    if (license != null && !license.equals("")) {
                        Transaction transaction = new Transaction();
                        transaction.vehicle = vehicleRepositry.getVehicles().get(license.toLowerCase());
                        transaction.user = userRepository.getUser(user);
                        if (mode.equalsIgnoreCase("rent")) {
                            transaction.rental.startDate = startDate;
                            transaction.rental.endDate = endDate;
                        } else {
                            transaction.reservation.startDate = startDate;
                            transaction.reservation.endDate = endDate;
                        }
                        transactionRepository.setTransaction(transaction);
                        Toast.makeText(SelectDates.this, "Vehicle " + mode + "ed successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SelectDates.this, ClientHome.class);
                        intent.putExtra("user", user);
                        intent.putExtra("mode", mode);
                        startActivity(intent);
                        SelectDates.this.finish();
                    } else {
                        Intent intent = new Intent(SelectDates.this, ViewVehicleClient.class);
                        intent.putExtra("startDate", startDate);
                        intent.putExtra("endDate", endDate);
                        intent.putExtra("mode", mode);
                        intent.putExtra("user", user);
                        startActivity(intent);
                    }
                } else
                    Toast.makeText(SelectDates.this, "Enter all fields", Toast.LENGTH_LONG).show();

            }
        });


        edtStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SelectDates.this,
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
                edtStartDate.setText(date);
                startDate = date;
            }
        };

        edtEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SelectDates.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth, dateSetListener2, year, month, day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                edtEndDate.setText(date);
                endDate = date;
            }
        };
    }
}
