package com.example.carrental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private static UserRepository instance = null;
    private Map<String, User> users = new HashMap<>();

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void addUser(User user) {
        this.users.put(user.userName, user);
    }

    public Map<String, User> getUsers() {
        return this.users;
    }

    public void deleteUser(String userName){
        users.remove(userName);
    }

    public void modifyUser(User user){
        users.put(user.userName.toLowerCase(), user);
    }
}
