import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner; // Import the Scanner class to read text files
    public class DealershipFileManager {
       private Dealership getDealership() {
           Dealership dealership = null;
           try {
               BufferedReader reader = new BufferedReader(new FileReader("dealership.csv"));
               String line = "";
               int lineNumber = 0;
               while ((line = reader.readLine()) != null) {
                   String[] parts = line.split("\\|");
                   if(lineNumber == 0){
                       String name = parts[0];
                       String address = parts[1];
                       String phone = parts[2];
                       dealership = new Dealership(name,address,phone);
                   }
                   else {
                       int vin = Integer.parseInt(parts[0]);
                       int year = Integer.parseInt(parts[1]);
                       String make = parts[2];
                       String model = parts[3];
                       String vehicleType = parts[4];
                       String color = parts[5];
                       int odometer = Integer.parseInt(parts[6]);
                       double price = Double.parseDouble(parts[7]);
                       Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                       dealership.addVehicle(vehicle);
                   }

                   lineNumber++;
               }
               reader.close();
           } catch (IOException e) {
               System.out.println("Error loading inventory: " + e.getMessage());
           }
       return dealership;
       }
       private void saveDealership(Dealership dealership){

       }
    }



