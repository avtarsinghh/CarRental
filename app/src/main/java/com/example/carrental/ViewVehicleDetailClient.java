package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewVehicleDetailClient extends AppCompatActivity {
    Intent intent;
    Vehicle vehicle;
    VehicleRepositry vehicleRepositry;
    TextView tvBrand, tvModel, tvType, tvYear, tvLicense, tvColor;
    Button btnReserve, btnRentNow;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicle_detail_client);

        tvBrand = findViewById(R.id.tvBrandVehicleDetailClient);
        tvColor = findViewById(R.id.tvColorVehicleDetailClient);
        tvModel = findViewById(R.id.tvModelVehicleDetailClient);
        tvYear = findViewById(R.id.tvYearVehicleDetailClient);
        tvType = findViewById(R.id.tvTypeVehicleDetailClient);
        tvLicense = findViewById(R.id.tvLicenseVehicleDetailClient);
        btnRentNow = findViewById(R.id.btnRentNowVehicleDetailClient);
        btnReserve = findViewById(R.id.btnReserveVehicleDetailClient);
        imageView = findViewById(R.id.imageViewVehicleDetailClient);

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

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewVehicleDetailClient.this, SelectDates.class);
                intent.putExtra("license", license);
                intent.putExtra("mode", "reserve");
                startActivity(intent);
            }
        });

        btnRentNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewVehicleDetailClient.this, SelectDates.class);
                intent.putExtra("mode", "rent");
                intent.putExtra("license", license);
                startActivity(intent);
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
