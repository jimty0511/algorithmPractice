package practice.ood;

import java.util.Map;

public class ParkingLot {
    public enum VehicleType {
        CAR, TRUCK, ELECTRIC, VAN, MOTORBIKE
    }

    public enum ParkingSpotType {
        HANDICAPPED, COMPACT, LARGE, MOTORBIKE, ELECTRIC
    }

    public enum AccountStatus {
        ACTIVE, BLOCKED, BANNED, COMPROMISED, ARCHIVED, UNKNOWN
    }

    public class Address {
        private String address, city, state, zipCode, country;
    }

    public class Person {
        private String name, email, phone;
        private Chess.Address address;
    }

    public abstract class Account {
        private String userName, password;
        private AccountStatus status;
        private Person person;

        public boolean resetPassword() {
            return false;
        }
    }

    public class Admin extends Account {
        public boolean addParkingFloor(ParkingFloor floor) {
            return false;
        }

        public boolean addParkingSpot(String floorName, ParkingSpot spot) {
            return false;
        }

    }

    public abstract class ParkingSpot {
        private String number;
        private boolean free;
        private Vehicle vehicle;
        private ParkingSpotType type;

        public boolean isFree() {
            return true;
        }

        public ParkingSpot(ParkingSpotType type) {
            this.type = type;
        }

        public ParkingSpotType getType() {
            return type;
        }

        public String getNumber() {
            return number;
        }

        public boolean assignVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            free = false;
            return true;
        }

        public boolean removeVehicle() {
            this.vehicle = null;
            free = true;
            return true;
        }
    }

    public class HandicappedSpot extends ParkingSpot {
        public HandicappedSpot() {
            super(ParkingSpotType.HANDICAPPED);
        }
    }

    public class CompactSpot extends ParkingSpot {
        public CompactSpot() {
            super(ParkingSpotType.COMPACT);
        }
    }

    public class MotorbikeSpot extends ParkingSpot {
        public MotorbikeSpot() {
            super(ParkingSpotType.MOTORBIKE);
        }
    }

    public class ElectricSpot extends ParkingSpot {
        public ElectricSpot() {
            super(ParkingSpotType.ELECTRIC);
        }
    }

    public abstract class Vehicle {
        private String licenseNum;
        private final VehicleType type;

        public Vehicle(VehicleType type) {
            this.type = type;
        }
    }

    public class Car extends Vehicle {
        public Car() {
            super(VehicleType.CAR);
        }
    }

    public class Van extends Vehicle {
        public Van() {
            super(VehicleType.VAN);
        }
    }

    public class Truck extends Vehicle {
        public Truck() {
            super(VehicleType.TRUCK);
        }
    }


    public class ParkingFloor {
        private String name;
        private Map<String, HandicappedSpot> handicappedSpotMap;
        private Map<String, CompactSpot> compactSpotMap;
        private Map<String, MotorbikeSpot> motorbikeSpotMap;

        public ParkingFloor(String name) {
            this.name = name;
        }

        public void addParkingSpot(ParkingSpot spot) {
            switch (spot.getType()) {
                case HANDICAPPED:
                    handicappedSpotMap.put(spot.getNumber(), (HandicappedSpot) spot);
                    break;
                case COMPACT:
                    compactSpotMap.put(spot.getNumber(), (CompactSpot) spot);
                    break;
                case MOTORBIKE:
                    motorbikeSpotMap.put(spot.getNumber(), (MotorbikeSpot) spot);
                    break;
                default:
                    System.out.println("Wrong type");
            }
        }

        public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
            spot.assignVehicle(vehicle);
            switch (spot.getType()) {
                case HANDICAPPED:

            }
        }

        public void freeSpot(ParkingSpot spot) {
            spot.removeVehicle();
            switch (spot.getType()) {

            }
        }
    }

    private String name;
    private Map<String, ParkingFloor> parkingFloorMap;
    private static ParkingLot parkingLot = null;

    private ParkingLot() {

    }

    public static ParkingLot getInstance() {
        if (parkingLot == null)
            parkingLot = new ParkingLot();
        return parkingLot;
    }
}
