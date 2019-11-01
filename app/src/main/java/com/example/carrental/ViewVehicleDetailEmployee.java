package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewVehicleDetailEmployee extends AppCompatActivity {
    Intent intent;
    Vehicle vehicle;
    VehicleRepositry vehicleRepositry;
    TextView tvBrand, tvModel, tvType, tvYear, tvLicense, tvColor;
    Button btnModify, btnDelete;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_detail_employee);

        tvBrand = findViewById(R.id.tvBrandVehicleDetailEmployee);
        tvColor = findViewById(R.id.tvColorVehicleDetailEmployee);
        tvModel = findViewById(R.id.tvModelVehicleDetailEmployee);
        tvYear = findViewById(R.id.tvYearVehicleDetailEmployee);
        tvType = findViewById(R.id.tvTypeVehicleDetailEmployee);
        tvLicense = findViewById(R.id.tvLicenseVehicleDetailEmployee);
        btnDelete = findViewById(R.id.btnDeleteVehicleDetailEmployee);
        btnModify = findViewById(R.id.btnModifyVehicleDetailEmployee);
        imageView = findViewById(R.id.imageViewVehicleDetailEmployee);

        vehicleRepositry = VehicleRepositry.getInstance();
        intent = getIntent();
        final String license = intent.getStringExtra("license").toLowerCase();
        vehicle = vehicleRepositry.getVehicles().get(license);
        if (vehicle != null) {
            tvBrand.setText(vehicle.brand);
            tvLicense.setText(vehicle.licencePlate);
            tvColor.setText(vehicle.color);
            tvModel.setText(vehicle.model);
            tvYear.setText(""+vehicle.year);
            tvType.setText(vehicle.type);
            setImage(vehicle.brand);
        }

        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewVehicleDetailEmployee.this, ModifyVehicle.class);
                intent.putExtra("license", license);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vehicleRepositry.removeVehicle(license);
                Intent intent = new Intent(ViewVehicleDetailEmployee.this, ViewVehiclesEmployee.class);
                startActivity(intent);
                ViewVehicleDetailEmployee.this.finish();
            }
        });
    }

    private void setImage(String brand) {
        switch (brand.toLowerCase()) {
            case "audi":
                imageView.setImageResource(R.drawable.audi);
                break;
            case "bmw":
                imageView.setImageResource(R.drawable.bmw);
                break;
            case "ford":
                imageView.setImageResource(R.drawable.ford);
                break;
            case "honda":
                imageView.setImageResource(R.drawable.honda);
                break;
            case "hyundai":
                imageView.setImageResource(R.drawable.hyundai);
                break;
            case "kia":
                imageView.setImageResource(R.drawable.kia);
                break;
            case "mazda":
                imageView.setImageResource(R.drawable.mazda);
                break;
            case "mercedes":
                imageView.setImageResource(R.drawable.mercedes);
                break;
            case "nissan":
                imageView.setImageResource(R.drawable.nissan);
                break;
            case "porsche":
                imageView.setImageResource(R.drawable.porsche);
                break;
            case "subaru":
                imageView.setImageResource(R.drawable.subaru);
                break;
            case "toyota":
                imageView.setImageResource(R.drawable.audi);
                break;
            case "volkswagen":
                imageView.setImageResource(R.drawable.audi);
                break;
            case "volvo":
                imageView.setImageResource(R.drawable.audi);
                break;
            default:
                imageView.setImageResource(android.R.drawable.stat_notify_error);
                break;
        }
    }
}
