package practice.lcdesign;

import java.util.HashMap;
import java.util.Map;

// 525. Mini Uber
// Chapter 5
public class MiniUber {

    static class Helper {
        public static double get_distance(double lat1, double lng1,
                                          double lat2, double lng2) {
            // return distance between (lat1, lng1) and (lat2, lng2)
            return (lat1 - lat2) * (lat1 - lat2) + (lng1 - lng2) * (lng1 - lng2);
        }
    }

    public class Trip {
        public int id; // trip's id, primary key
        public int driver_id, rider_id; // foreign key
        public double lat, lng; // pick up location

        public Trip(int rider_id, double lat, double lng) {
            this.rider_id = rider_id;
            this.lat = lat;
            this.lng = lng;
        }
    }

    public class Location {
        public double lat, lng;

        public Location(double _lat, double _lng) {
            lat = _lat;
            lng = _lng;
        }
    }

    Map<Integer, Trip> tripMap;
    Map<Integer, Location> locationMap;

    public MiniUber() {
        // initialize your data structure here.
        tripMap = new HashMap<>();
        locationMap = new HashMap<>();
    }

    // @param driver_id an integer
    // @param lat, lng driver's location
    // return matched trip information if there have matched rider or null
    public Trip report(int driver_id, double lat, double lng) {
        // Write your code here
        if (tripMap.containsKey(driver_id))
            return tripMap.get(driver_id);
        if (locationMap.containsKey(driver_id)) {
            locationMap.get(driver_id).lat = lat;
            locationMap.get(driver_id).lng = lng;
        } else {
            locationMap.put(driver_id, new Location(lat, lng));
        }
        return null;
    }

    // @param rider_id an integer
    // @param lat, lng rider's location
    // return a trip
    public Trip request(int rider_id, double lat, double lng) {
        // Write your code here
        Trip trip = new Trip(rider_id, lat, lng);
        double distance = -1;
        int driver_id = -1;
        for (Map.Entry<Integer, Location> entry : locationMap.entrySet()) {
            Location location = entry.getValue();
            double dis = Helper.get_distance(location.lat, location.lng, lat, lng);
            if (distance < 0 || distance > dis) {
                driver_id = entry.getKey();
                distance = dis;
            }
        }
        if (driver_id != -1) {
            locationMap.remove(driver_id);
        }
        trip.driver_id = driver_id;
        tripMap.put(driver_id, trip);
        return trip;
    }
}
