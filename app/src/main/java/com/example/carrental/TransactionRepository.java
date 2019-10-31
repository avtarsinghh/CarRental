package com.example.carrental;

import java.util.HashMap;
import java.util.Map;

public class TransactionRepository {
    private static TransactionRepository instance;
    private static Map<String, Transaction> transactionMap = new HashMap<>();

    private TransactionRepository(){}

    public static TransactionRepository getInstance(){
        if(instance == null){
            instance = new TransactionRepository();
        }
        return instance;
    }

    public Map<String, Transaction> getTransactions(){
        return instance.transactionMap;
    }

    public void setTransaction(Transaction transaction){
        instance.transactionMap.put((transaction.user.userName+transaction.vehicle.licencePlate).toLowerCase(), transaction);
    }
}
