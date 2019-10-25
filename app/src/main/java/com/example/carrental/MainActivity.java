package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    UserRepository userRepository;
    VehicleRepositry vehicleRepositry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userRepository = UserRepository.getInstance();
        vehicleRepositry = VehicleRepositry.getInstance();

        createUsers();
        createVehicles();

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Login.class));
            }
        }, 5000);
    }

    private void createUsers() {
        User user = new User();
        user.firstName = "Avtar";
        user.lastName = "Gill";
        user.role = "Employee";
        user.password = "CarRental";
        user.userName = "avtargill";
        userRepository.addUser(user);

        User user1 = new User();
        user1.firstName = "Amardeep";
        user1.lastName = "Kaur";
        user1.role = "Client";
        user1.password = "CarRental";
        user1.userName = "amardeepkaur";
        userRepository.addUser(user1);
    }

    private void createVehicles() {
        Vehicle vehicle = new Vehicle();
        vehicle.brand = "BMW";
        vehicle.color = "black";
        vehicle.licencePlate = "E6h 789";
        vehicle.model = "X6";
        vehicle.type = "SUV";
        vehicle.year = 2019;
        vehicleRepositry.addVehicle(vehicle);

        Vehicle vehicle1 = new Vehicle();
        vehicle1.brand = "AUDI";
        vehicle1.color = "black";
        vehicle1.licencePlate = "A22 789";
        vehicle1.model = "A8";
        vehicle1.type = "Sedan";
        vehicle1.year = 2019;
        vehicleRepositry.addVehicle(vehicle1);
    }
}
