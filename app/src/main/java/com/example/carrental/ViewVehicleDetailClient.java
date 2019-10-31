package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewVehicleDetailClient extends AppCompatActivity {
    Intent intent;
    Vehicle vehicle;
    VehicleRepositry vehicleRepositry;
    TextView tvBrand, tvModel, tvType, tvYear, tvLicense, tvColor;
    Button btnReserve, btnRentNow;
    ImageView imageView;
    String user, mode, license, startDate, endDate;
    UserRepository userRepository;
    TransactionRepository transactionRepository;
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

        userRepository = UserRepository.getInstance();
        vehicleRepositry = VehicleRepositry.getInstance();
        transactionRepository = TransactionRepository.getInstance();

        intent = getIntent();
        user = intent.getStringExtra("user");
        mode = intent.getStringExtra("mode");
        startDate = intent.getStringExtra("startDate");
        endDate = intent.getStringExtra("endDate");
        license = intent.getStringExtra("license").toLowerCase();
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

        if(startDate != null && endDate != null && license != null){
            btnReserve.setVisibility(View.GONE);
            btnRentNow.setText("Done");
        }

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewVehicleDetailClient.this, SelectDates.class);
                intent.putExtra("license", license);
                intent.putExtra("mode", "reserve");
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });

        btnRentNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startDate.equalsIgnoreCase("") && endDate.equalsIgnoreCase("")) {
                    Intent intent = new Intent(ViewVehicleDetailClient.this, SelectDates.class);
                    intent.putExtra("mode", "rent");
                    intent.putExtra("license", license);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }
                else{
                    Transaction transaction = new Transaction();
                    transaction.vehicle = vehicleRepositry.getVehicles().get(license.toLowerCase());
                    transaction.user = userRepository.getUser(user.toLowerCase());
                    if(mode.equalsIgnoreCase("rent")){
                        transaction.rental.startDate = startDate;
                        transaction.rental.endDate = endDate;
                    }
                    else {
                        transaction.reservation.startDate = startDate;
                        transaction.reservation.endDate = endDate;
                    }
                    transactionRepository.setTransaction(transaction);
                    Toast.makeText(ViewVehicleDetailClient.this, "Vehicle "+mode+"ed successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ViewVehicleDetailClient.this, ClientHome.class);
                    intent.putExtra("user", user);
                    intent.putExtra("mode", mode);
                    startActivity(intent);
                }
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
