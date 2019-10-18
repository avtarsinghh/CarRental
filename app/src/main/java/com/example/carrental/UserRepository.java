package com.example.carrental;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static UserRepository instance = null;
    private List<User> users = new ArrayList<>();

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void addAnimal(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return this.users;
    }
}
