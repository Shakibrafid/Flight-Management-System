/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.theory;

/**
 *
 * @author Dell
 */
import java.util.ArrayList;

public class User {
    String name;
    int userID;
    String phoneNumber;
    String email;
    String password;
    String city;
    String country;

    public User(String name, int userID, String phoneNumber, String email, String password, String city, String country) {
        this.name = name;
        this.userID = userID;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public ArrayList<Booking> getBookings() {
        // Placeholder for actual implementation
        return new ArrayList<>();
    }
}
