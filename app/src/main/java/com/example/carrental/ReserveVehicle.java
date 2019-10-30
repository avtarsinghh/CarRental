package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class ReserveVehicle extends AppCompatActivity
{
    private EditText edtStartDate,edtEndDate;
    Button btnReserve;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private DatePickerDialog.OnDateSetListener dateSetListener2;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_vehicle);

        edtStartDate=(EditText)findViewById(R.id.edtStartDateActivityReserveVehicle);
        edtEndDate=(EditText)findViewById(R.id.edtEndDateActivityReserveVehicle);

        edtStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog=new DatePickerDialog(ReserveVehicle.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,dateSetListener,year,month,day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month=month+1;

                Log.d(TAG, "onDateSet: mm/dd/yyyy" +month+ "/" +day+ "/" +year);

                String date=month +"/" +day+ "/" +year ;
                edtStartDate.setText(date);
            }
        };

        edtEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog=new DatePickerDialog(ReserveVehicle.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,dateSetListener2,year,month,day);

                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        dateSetListener2=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month=month+1;

                Log.d(TAG, "onDateSet: mm/dd/yyyy" +month+ "/" +day+ "/" +year);

                String date=month +"/" +day+ "/" +year ;
                edtEndDate.setText(date);
            }
        };
    }
}
