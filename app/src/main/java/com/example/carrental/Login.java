package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Button login;
    EditText uNameET, passwordET;
    UserRepository userRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.btnLogin);
        uNameET = findViewById(R.id.edtUserName);
        passwordET = findViewById(R.id.edtPassword);
        userRepository = UserRepository.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = uNameET.getText().toString();
                String password  =passwordET.getText().toString();
                int i = 0;
                boolean userFind = false;
                if(userRepository.getUsers().containsKey(uName)){
                    User user = userRepository.getUsers().get(uName);
                    if(user.password.equals(password)){
                        if(user.role.equalsIgnoreCase("Employee")){
                            Intent intent = new Intent(Login.this, EmployeeHome.class);
                            startActivity(intent);
                        }
                        else if(user.role.equalsIgnoreCase("Client")){
                            Intent intent = new Intent(Login.this, ClientHome.class);
                            startActivity(intent);
                        }
                    }
                    else {
                        Toast.makeText(Login.this, "Invalid User Credentials", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(Login.this, "Invalid User Credentials", Toast.LENGTH_LONG).show();
                }
                /*while (i < userRepository.getUsers().size()){
                    User user = userRepository.getUsers().get(i);
                    if(user.userName.equalsIgnoreCase(uName)){
                        if(user.password.equals(password)){
                            if(user.role.equalsIgnoreCase("Employee")){
                                Intent intent = new Intent(Login.this, EmployeeHome.class);
                                startActivity(intent);
                            }
                            else if(user.role.equalsIgnoreCase("Client")){
                                Intent intent = new Intent(Login.this, ClientHome.class);
                                startActivity(intent);
                            }
                            userFind = true;
                        }
                    }
                    i++;
                }

                if(userFind == false){
                    Toast.makeText(Login.this, "Invalid User Credentials", Toast.LENGTH_LONG).show();
                }*/
            }
        });
    }
}
