package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CarsDetails extends AppCompatActivity {

    TextView txtTypeCD,txtBrandCD,txtModelCD,txtColorCD,txtYearCD,txtLicenseCD;
    Button btnRentCD,btnReserveCD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_detail);

        txtTypeCD=findViewById(R.id.txtTypeCarDetail);
        txtBrandCD=findViewById(R.id.txtBrandCarDetail);
        txtModelCD=findViewById(R.id.txtModelCarDetail);
        txtColorCD=findViewById(R.id.txtColourCarDetail);
        txtYearCD=findViewById(R.id.txtYearCarDetail);
        txtLicenseCD=findViewById(R.id.txtlicenseCarDetail);
        btnRentCD=findViewById(R.id.btnRentCarDetail);
        btnReserveCD=findViewById(R.id.btnReserveCarDetail);


        btnReserveCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CarsDetails.this,ReserveVehicle.class);
                startActivity(intent);
            }
        });

        btnRentCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CarsDetails.this,RentNow.class);
                startActivity(intent);
            }
        });
    }
}
