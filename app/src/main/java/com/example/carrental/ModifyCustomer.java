package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifyCustomer extends AppCompatActivity {
    EditText etFirstName, etLastName, etUserName, etPassword;
    Button btnModify;
    Intent intent;
    String userName;
    UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_customer);
        btnModify = findViewById(R.id.btnModifyCustomer);
        etFirstName = findViewById(R.id.etFirstNameModifyCustomer);
        etLastName = findViewById(R.id.etLastNameModifyCustomer);
        etUserName = findViewById(R.id.etUserNameModifyCustomer);
        etPassword = findViewById(R.id.etPasswordModifyCustomer);

        userRepository = UserRepository.getInstance();

        intent = getIntent();
        userName = intent.getStringExtra("username").toLowerCase();
        User user = userRepository.getUser(userName.toLowerCase());
        if (user != null) {
            etFirstName.setText(user.firstName);
            etLastName.setText(user.lastName);
            etUserName.setText(user.userName);
        }


        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName, lName, uName, password;
                fName = etFirstName.getText().toString();
                lName = etLastName.getText().toString();
                uName = etUserName.getText().toString().toLowerCase();
                password = etPassword.getText().toString();
                if (fName.equals("") || lName.equals("") || uName.equals("") || password.equals("")) {
                    Toast.makeText(ModifyCustomer.this, "Please enter all credentials!!!", Toast.LENGTH_LONG).show();
                } else {
                    User user1 = new User();
                    user1.firstName = fName;
                    user1.lastName = lName;
                    user1.userName = uName;
                    user1.password = password;
                    user1.role = "Client";
                    userRepository.deleteUser(userName);
                    userRepository.addUser(user1);
                    Intent intent = new Intent(ModifyCustomer.this, ViewCustomers.class);
                    startActivity(intent);
                    ModifyCustomer.this.finish();
                }
            }
        });
    }
}
