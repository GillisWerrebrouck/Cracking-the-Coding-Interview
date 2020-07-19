import java.util.ArrayList;

/**
 * Object-oriented design for a parking lot.
 * 
 * @author Gillis Werrebrouck
 */

public class Parking_Lot {
    public static void main(final String args[]) {
        ParkingLot parkingLot = new ParkingLot();
        ParkingLevel level = new ParkingLevel(1);
        ParkingSpot parkingSpot = new ParkingSpot(VehicleSize.compact, level, 0);
        parkingLot.parkingSpots.add(parkingSpot);

        Vehicle car = new Car("ABC123");
        boolean canFitInSpot = car.canFitInParkingSpot(parkingSpot);
    }
}

enum VehicleSize {
    small,
    compact,
    large,
}

abstract class Vehicle {
    protected String licensePlate;
    protected VehicleSize size;

    public boolean canFitInParkingSpot(ParkingSpot parkingSpot) {
        return true;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleSize getSize() {
        return size;
    }
}

class Car extends Vehicle {
    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
        this.size = VehicleSize.compact;
    }

    public boolean canFitInParkingSpot(ParkingSpot parkingSpot) {
        // TODO: add implementation
        return true;
    }
}

class Bus extends Vehicle {
    public Bus(String licensePlate) {
        this.licensePlate = licensePlate;
        this.size = VehicleSize.large;
    }

    public boolean canFitInParkingSpot(ParkingSpot parkingSpot) {
        // TODO: add implementation
        return true;
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.size = VehicleSize.large;
    }

    public boolean canFitInParkingSpot(ParkingSpot parkingSpot) {
        // TODO: add implementation
        return true;
    }
}

class ParkingLevel {
    private int floor;
    private ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    private int availableSpots;

    public ParkingLevel(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public ArrayList<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setAvailableSpots(int availableSpots) {
        this.availableSpots = availableSpots;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }

    public int getAvailableParkingSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        // TODO: add implementation
        return true;
    }

    public void makeSpotAvailable(ParkingSpot parkingSpot) {
        // TODO: add implementation
    }
}

class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize size;
    private ParkingLevel parkingLevel;
    private int spotNumber;

    public ParkingSpot(VehicleSize size, ParkingLevel parkingLevel, int spotNumber) {
        this.size = size;
        this.parkingLevel = parkingLevel;
        this.spotNumber = spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleSize getSize() {
        return size;
    }

    public ParkingLevel getParkingLevel() {
        return parkingLevel;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}

class ParkingLot {
    ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
    public ParkingLevel[] parkingLevels;

    public ParkingLot() {}

    public boolean parkVehicle(Vehicle vehicle) {
        // TODO: add implementation
        return true;
    }
}
