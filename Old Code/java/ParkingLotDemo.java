// import java.util.*;

// public class ParkingLot {

//     public static void main(String[] args) {
//         ParkingLot lot = new ParkingLot(2, 2, 1); 

//         Vehicle car1 = new Vehicle("WB32", VehicleType.CAR);
//         Vehicle bike1 = new Vehicle("WB31", VehicleType.BIKE);
//         Vehicle truck1 = new Vehicle("WB30", VehicleType.TRUCK);
//         lot.parkVehicle(car1);
//         lot.parkVehicle(bike1);
//         lot.parkVehicle(truck1);
//         lot.displayAvailableSlots();
//         lot.removeVehicle("WB32"); 
//         lot.displayAvailableSlots();
//     }
// }

// enum VehicleType {
//     CAR, BIKE, TRUCK
// }


// class Vehicle {
//     String number;
//     VehicleType type;

//     public Vehicle(String number, VehicleType type) {
//         this.number = number;
//         this.type = type;
//     }
// }

// class ParkingSlot {
//     int slotNumber;
//     VehicleType type;
//     boolean isOccupied;
//     Vehicle vehicle;

//     public ParkingSlot(int slotNumber, VehicleType type) {
//         this.slotNumber = slotNumber;
//         this.type = type;
//         this.isOccupied = false;
//     }
// }

// class ParkingLot {

//     private Map<String, ParkingSlot> parkedVehicles = new HashMap<>();

//     private PriorityQueue<ParkingSlot> carSlots =
//             new PriorityQueue<>(Comparator.comparingInt(s -> s.slotNumber));

//     private PriorityQueue<ParkingSlot> bikeSlots =
//             new PriorityQueue<>(Comparator.comparingInt(s -> s.slotNumber));

//     private PriorityQueue<ParkingSlot> truckSlots =
//             new PriorityQueue<>(Comparator.comparingInt(s -> s.slotNumber));

//     public ParkingLot(int carCount, int bikeCount, int truckCount) {

//         for (int i = 1; i <= carCount; i++)
//             carSlots.add(new ParkingSlot(i, VehicleType.CAR));

//         for (int i = 1; i <= bikeCount; i++)
//             bikeSlots.add(new ParkingSlot(i, VehicleType.BIKE));

//         for (int i = 1; i <= truckCount; i++)
//             truckSlots.add(new ParkingSlot(i, VehicleType.TRUCK));
//     }

//     public void parkVehicle(Vehicle vehicle) {
//         PriorityQueue<ParkingSlot> queue = getQueue(vehicle.type);

//         if (queue.isEmpty()) {
//             System.out.println("No slot available for " + vehicle.type);
//             return;
//         }

//         ParkingSlot slot = queue.poll();
//         slot.isOccupied = true;
//         slot.vehicle = vehicle;

//         parkedVehicles.put(vehicle.number, slot);

//         System.out.println("Parked " + vehicle.number + " at slot " + slot.slotNumber);
//     }

//     public void removeVehicle(String vehicleNumber) {
//         if (!parkedVehicles.containsKey(vehicleNumber)) {
//             System.out.println("Vehicle not found");
//             return;
//         }

//         ParkingSlot slot = parkedVehicles.get(vehicleNumber);
//         slot.isOccupied = false;

//         getQueue(slot.type).add(slot);
//         parkedVehicles.remove(vehicleNumber);

//         System.out.println("Removed vehicle " + vehicleNumber + " from slot " + slot.slotNumber);
//     }

//     public void displayAvailableSlots() {
//         System.out.println("Available CAR slots: " + carSlots.size());
//         System.out.println("Available BIKE slots: " + bikeSlots.size());
//         System.out.println("Available TRUCK slots: " + truckSlots.size());
//     }

//     private PriorityQueue<ParkingSlot> getQueue(VehicleType type) {
//         switch (type) {
//             case CAR: return carSlots;
//             case BIKE: return bikeSlots;
//             case TRUCK: return truckSlots;
//             default: throw new IllegalArgumentException("Invalid type");
//         }
//     }
// }
