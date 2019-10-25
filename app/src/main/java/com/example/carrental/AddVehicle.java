package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddVehicle extends AppCompatActivity {
    Spinner brandSpinner, typeSpinner;
    EditText etColor, etModel, etYear, etLicencePlate;
    Button addVehicle;
    ArrayList<String> brands, types;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        brandSpinner = findViewById(R.id.spinnerBrandModifyVehicle);
        typeSpinner = findViewById(R.id.spinnerTypeModifyVehicle);
        etColor = findViewById(R.id.etColorModifyVehicle);
        etModel = findViewById(R.id.etModelModifyVehicle);
        etYear = findViewById(R.id.etYearModifyVehicle);
        etLicencePlate = findViewById(R.id.etPlateNumberModifyVehicle);
        addVehicle = findViewById(R.id.btnModifyVehicle);

        setTypes();
        setBrands();
        addVehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setBrands(){
        brands = new ArrayList<>();
        brands.add("Select Brand");
        brands.add("Audi");
        brands.add("BMW");
        brands.add("Ford");
        brands.add("Honda");
        brands.add("Hyundai");
        brands.add("Kia");
        brands.add("Mazda");
        brands.add("Mercedes");
        brands.add("Nissan");
        brands.add("Porsche");
        brands.add("Subaru");
        brands.add("Toyota");
        brands.add("Volkswagen");
        brands.add("Volvo");
    }

    public void setTypes(){
        types = new ArrayList<>();
        types.add("Hatchback");
        types.add("Sedan");
        types.add("MPV");
        types.add("SUV");
        types.add("Crossover");
        types.add("Coupe");
        types.add("Convertible");
    }
}
