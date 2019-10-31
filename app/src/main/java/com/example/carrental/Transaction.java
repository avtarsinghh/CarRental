package com.example.carrental;

public class Transaction {
    User user;
    Vehicle vehicle;
    Rental rental;
    Reservation reservation;
    String returnDate;
    Transaction(){
        rental = new Rental();
        reservation = new Reservation();
    }
}
class Rental{
    public String startDate, endDate;
}

class Reservation{
    public String startDate, endDate;
}