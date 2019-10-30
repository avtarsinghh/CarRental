package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RentNow extends AppCompatActivity {

    TextView txtType,txtBrand,txtModel,txtColor,txtYear,txtLicense;
    Button btnRentNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_now);

        txtType=findViewById(R.id.txtTypeActivityRentNow);
        txtBrand=findViewById(R.id.txtBrandRentNow);
        txtModel=findViewById(R.id.txtModelActivityRentNow);
        txtColor=findViewById(R.id.txtColourActivityRentNow);
        txtYear=findViewById(R.id.txtYearActivityRentNow);
        txtLicense=findViewById(R.id.txtLicenceActivityRentNow);
        btnRentNow=findViewById(R.id.btnRentActivityRentNow);

        btnRentNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

            }
        });
    }
}
