
package project.theory;

import java.util.ArrayList;

public class Admin {
    private String name;
    private int adminID;
    private String password;

    public Admin(String name, int adminID, String password) {
        this.name = name;
        this.adminID = adminID;
        this.password = password;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean cancelFlight(String flightNumber) {
        
        ArrayList<Flight> flights = FlightManager.loadFlights();

        
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                
                boolean canceled = flight.cancel(); 

                if (canceled) {
                    
                    FlightManager.saveFlights(flights);

               
                    System.out.println("Flight " + flightNumber + " cancelled successfully by admin " + name);
                    return true;
                } else {
                  
                    System.out.println("Failed to cancel flight " + flightNumber);
                    return false;
                }
            }
        }

      
        System.out.println("Flight with number " + flightNumber + " not found.");
        return false;
    }

    public boolean modifyFlight(Flight modifiedFlight) {
        ArrayList<Flight> flights = FlightManager.loadFlights();


        for (int i = 0; i < flights.size(); i++) {
            Flight flight = flights.get(i);
            if (flight.getFlightNumber().equals(modifiedFlight.getFlightNumber())) {
          
                flights.set(i, modifiedFlight);

         
                FlightManager.saveFlights(flights);

              
                System.out.println("Flight " + modifiedFlight.getFlightNumber() + " modified successfully by admin " + name);
                return true;
            }
        }

     
        System.out.println("Flight with number " + modifiedFlight.getFlightNumber() + " not found for modification.");
        return false;
    }
}
