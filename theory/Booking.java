/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.theory;

/**
 *
 * @author Dell
 */
public class Booking {
    private String bookingId;
    private String userId;
    private String flightNumber;
    private String departure;
    private String destination;
    private String departureTime;
    private String arrivalTime;

    // Constructor
    public Booking(String bookingId, String userId, String flightNumber, String departure, String destination, String departureTime, String arrivalTime) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Getters and setters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

     public String toString() {
        return "Booking ID: " + bookingId + "\n" +
               "User ID: " + userId + "\n" +
               "Flight Number: " + flightNumber + "\n" +
               "Departure: " + departure + "\n" +
               "Destination: " + destination + "\n" +
               "Departure Time: " + departureTime + "\n" +
               "Arrival Time: " + arrivalTime;
}}
