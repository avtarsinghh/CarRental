package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCustomer extends AppCompatActivity {
    EditText etFirstName, etLastName, etUserName, etPassword;
    UserRepository userRepository;
    Button addCustomer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        etFirstName = findViewById(R.id.etModelAddVehicle);
        etLastName = findViewById(R.id.spinnerTypeAddVehicle);
        etUserName = findViewById(R.id.etYearAddVehicle);
        etPassword = findViewById(R.id.etColorAddVehicle);

        addCustomer = findViewById(R.id.btnAddCustomer);
        userRepository = UserRepository.getInstance();
        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName, lName, uName, password;
                fName = etFirstName.getText().toString();
                lName = etLastName.getText().toString();
                uName = etUserName.getText().toString().toLowerCase();
                password = etPassword.getText().toString();
                if(fName.equals("") || lName.equals("") || uName.equals("") || password.equals("")){
                    Toast.makeText(AddCustomer.this, "Fill all the credentials", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(!userRepository.getUsers().containsKey(uName)){
                        User user = new User();
                        user.firstName = fName;
                        user.lastName = lName;
                        user.userName = uName;
                        user.password = password;
                        user.role = "client";
                        userRepository.addUser(user);
                        etFirstName.setText("");
                        etLastName.setText("");
                        etPassword.setText("");
                        etUserName.setText("");
                        Toast.makeText(AddCustomer.this, "Customer Added successfully", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(AddCustomer.this, "UserName already exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
