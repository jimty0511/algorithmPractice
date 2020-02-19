package practice.lcood;

import java.util.ArrayList;
import java.util.List;

// 498. Parking Lot
public class ParkingLot {

    private Level[] levels;
    private int NUM_LEVELS;

    // @param n number of leves
    // @param num_rows  each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    public ParkingLot(int n, int num_rows, int spots_per_row) {
        // Write your code here
        this.NUM_LEVELS = n;
        this.levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels[i] = new Level(i, num_rows, spots_per_row);
        }
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].parkVehicle(vehicle))
                return true;
        }
        return false;
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
        vehicle.clearSpots();
    }

    public void print() {
        for (int i = 0; i < levels.length; i++) {
            System.out.print("Level" + i + ": ");
            levels[i].print();
            System.out.println("");
        }
        System.out.println("");
    }

    enum VehicleSize {
        Motorcycle, Compact, Large
    }

    abstract class Vehicle {
        protected int spotsNeeded;
        protected VehicleSize size;
        protected String licensePlate;

        protected List<ParkingSpot> parkingSpots = new ArrayList<>();

        public int getSpotsNeeded() {
            return spotsNeeded;
        }

        public VehicleSize getSize() {
            return size;
        }

        public void parkInSpot(ParkingSpot spot) {
            parkingSpots.add(spot);
        }

        public void clearSpots() {
            for (int i = 0; i < parkingSpots.size(); i++)
                parkingSpots.get(i);
            parkingSpots.clear();
        }

        public abstract boolean canFitInSpot(ParkingSpot spot);

        public abstract void print();
    }

    class Motorcycle extends Vehicle {
        public Motorcycle() {
            spotsNeeded = 1;
            size = VehicleSize.Motorcycle;
        }

        public boolean canFitInSpot(ParkingSpot spot) {
            return true;
        }

        public void print() {
            System.out.println("M");
        }
    }

    class Car extends Vehicle {
        public Car() {
            spotsNeeded = 1;
            size = VehicleSize.Compact;
        }

        public boolean canFitInSpot(ParkingSpot spot) {
            return spot.getSize() == VehicleSize.Large || spot.getSize() == VehicleSize.Compact;
        }

        public void print() {
            System.out.println("C");
        }
    }

    class Bus extends Vehicle {
        public Bus() {
            spotsNeeded = 5;
            size = VehicleSize.Large;
        }

        public boolean canFitInSpot(ParkingSpot spot) {
            return spot.getSize() == VehicleSize.Large;
        }

        public void print() {
            System.out.print("B");
        }
    }

    class Level {
        private int floor;
        private ParkingSpot[] spots;
        private int availableSpots = 0;
        private int SPOTS_PER_ROW;

        public Level(int floor, int rows, int spots_per_row) {
            this.floor = floor;
            this.SPOTS_PER_ROW = SPOTS_PER_ROW;
            this.spots = new ParkingSpot[rows * spots_per_row];
            int numberSpots = 0;
            for (int row = 0; row < rows; ++row) {
                for (int spot = 0; spot < spots_per_row / 4; ++spot) {
                    VehicleSize sz = VehicleSize.Motorcycle;
                    spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                    numberSpots++;
                }
                for (int spot = spots_per_row / 4; spot < spots_per_row / 4 * 3; ++spot) {
                    VehicleSize sz = VehicleSize.Compact;
                    spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                    numberSpots++;
                }
                for (int spot = spots_per_row / 4 * 3; spot < spots_per_row; ++spot) {
                    VehicleSize sz = VehicleSize.Large;
                    spots[numberSpots] = new ParkingSpot(this, row, numberSpots, sz);
                    numberSpots++;
                }
            }
            availableSpots = numberSpots;
        }

        public boolean parkVehicle(Vehicle vehicle) {
            if (availableSpots() < vehicle.getSpotsNeeded())
                return false;
            int spotNum = findAvailableSpots(vehicle);
            if (spotNum < 0)
                return false;
            return parkStartingAtSpot(spotNum, vehicle);
        }

        private int findAvailableSpots(Vehicle vehicle) {
            int spotsNeeded = vehicle.getSpotsNeeded();
            int lastRow = -1;
            int spotsFound = 0;

            for (int i = 0; i < spots.length; i++) {
                ParkingSpot spot = spots[i];
                if (lastRow != spot.getRow()) {
                    spotsFound = 0;
                    lastRow = spot.getRow();
                }
                if (spot.canFitVehicle(vehicle)) {
                    spotsFound++;
                } else {
                    spotsFound = 0;
                }
                if (spotsFound == spotsNeeded) {
                    return i - (spotsNeeded - 1); // index of spot
                }
            }
            return -1;
        }

        private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
            vehicle.clearSpots();

            boolean success = true;

            for (int i = spotNumber; i < spotNumber + vehicle.spotsNeeded; i++) {
                success &= spots[i].park(vehicle);
            }

            availableSpots -= vehicle.spotsNeeded;
            return success;
        }

        public void spotFreed() {
            availableSpots++;
        }

        public int availableSpots() {
            return availableSpots;
        }

        public void print() {
            int lastRow = -1;
            for (int i = 0; i < spots.length; i++) {
                ParkingSpot spot = spots[i];
                if (spot.getRow() != lastRow) {
                    System.out.print("  ");
                    lastRow = spot.getRow();
                }
                spot.print();
            }
        }
    }

    class ParkingSpot {
        private Vehicle vehicle;
        private VehicleSize spotSize;
        private int row;
        private int spotNumber;
        private Level level;

        public ParkingSpot(Level level, int row, int spotNumber, VehicleSize spotSize) {
            this.spotSize = spotSize;
            this.row = row;
            this.spotNumber = spotNumber;
            this.level = level;
        }

        public boolean isAvailable() {
            return vehicle == null;
        }

        public boolean canFitVehicle(Vehicle vehicle) {
            return isAvailable() && vehicle.canFitInSpot(this);
        }

        public boolean park(Vehicle v) {
            if (!canFitVehicle(v))
                return false;
            vehicle = v;
            vehicle.parkInSpot(this);
            return true;
        }

        public void removeVehicle() {
            level.spotFreed();
            vehicle = null;
        }

        public VehicleSize getSize() {
            return spotSize;
        }

        public int getRow() {
            return row;
        }

        public int getSpotNumber() {
            return spotNumber;
        }

        public void print() {
            if (vehicle == null) {
                if (spotSize == VehicleSize.Compact)
                    System.out.println("c");
                else if (spotSize == VehicleSize.Large)
                    System.out.println("l");
                else if (spotSize == VehicleSize.Motorcycle)
                    System.out.println("m");
            } else {
                vehicle.print();
            }
        }
    }

}
