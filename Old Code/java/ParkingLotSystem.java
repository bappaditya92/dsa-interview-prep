import java.util.HashMap;
import java.util.Map;

class Vehicle {
    private String vehicleNumber;
    private String vehicleType;

    public Vehicle(String vehicleNumber, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}

class ParkingLot {
    private int capacity;
    private Map<String, Vehicle> parkedVehicles;
    private double totalRevenue;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkedVehicles = new HashMap<>();
        this.totalRevenue = 0;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (parkedVehicles.size() >= capacity) {
            System.out.println("Parking Full! Cannot park "
                    + vehicle.getVehicleNumber());
            return;
        }

        parkedVehicles.put(vehicle.getVehicleNumber(), vehicle);
        System.out.println(vehicle.getVehicleNumber()
                + " parked successfully.");
    }

    public void exitVehicle(String vehicleNumber, int hoursParked) {
        Vehicle vehicle = parkedVehicles.remove(vehicleNumber);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        double fee;

        if (vehicle.getVehicleType().equalsIgnoreCase("Car")) {
            fee = hoursParked * 20;
        } else {
            fee = hoursParked * 10;
        }

        totalRevenue += fee;

        System.out.println("Vehicle " + vehicleNumber + " exited.");
        System.out.println("Parking Fee: ₹" + fee);
    }

    public void displayStatus() {
        System.out.println("\n----- Parking Lot Status -----");
        System.out.println("Total Vehicles Parked: "
                + parkedVehicles.size());
        System.out.println("Available Slots: "
                + (capacity - parkedVehicles.size()));
        System.out.println("Total Revenue: ₹"
                + totalRevenue);
    }
}

public class ParkingLotSystem {
    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(3);

        lot.parkVehicle(new Vehicle("WB34A1234", "Car"));
        lot.parkVehicle(new Vehicle("WB34B5678", "Bike"));
        lot.parkVehicle(new Vehicle("WB34C9999", "Car"));

        lot.exitVehicle("WB34B5678", 2);

        lot.parkVehicle(new Vehicle("WB34D1111", "Bike"));

        lot.displayStatus();
    }
}
