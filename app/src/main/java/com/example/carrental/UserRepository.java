package com.example.carrental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static UserRepository instance = null;
    private Map<String, User> users = new HashMap<>();

    private UserRepository(){}

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

    public User getUser(String userName){
        return users.get(userName);
    }

    public Map<String, User> getCustomers(){
        Map<String, User> userCustomer = new HashMap<>();
        ArrayList<String> userNames = new ArrayList<>(instance.users.keySet());
        for(int i = 0; i < userNames.size(); i++){
            if(instance.users.get(userNames.get(i)).role.equalsIgnoreCase("client")){
                userCustomer.put(userNames.get(i), instance.users.get(userNames.get(i)));
            }
        }
        return userCustomer;
    }
}
