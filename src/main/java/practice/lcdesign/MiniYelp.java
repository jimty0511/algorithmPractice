package practice.lcdesign;

import java.util.*;

// 509. Mini Yelp
// Chapter 5
public class MiniYelp {

    static class Location {
        public double latitude, longitude;

        public static Location create(double lati, double longi) {
            // This will create a new location object
            Location location = new Location();
            location.latitude = lati;
            location.longitude = longi;
            return location;
        }
    }

    static class Restaurant {
        public int id;
        public String name;
        public Location location;

        public static Restaurant create(String name, Location location) {
            // This will create a new restaurant object,
            // and auto fill id
            Restaurant restaurant = new Restaurant();
            restaurant.name = name;
            restaurant.location = location;
            return restaurant;
        }
    }

    static class Helper {
        public static double get_distance(Location location1, Location location2) {
            // return distance between location1 and location2.
            return (location1.latitude - location2.latitude) * (location1.latitude - location2.latitude) + (location1.longitude - location2.longitude) * (location1.longitude - location2.longitude);
        }
    }

    static class GeoHash {
        public static String encode(Location location) {
            // return convert location to a GeoHash string
            return "";
        }

        public static Location decode(String hashcode) {
            // return convert a GeoHash string to location
            return new Location();
        }
    }

    class Node {
        public double distance;
        public Restaurant restaurant;

        public Node(double d, Restaurant r) {
            distance = d;
            restaurant = r;
        }
    }

    private TreeMap<String, Restaurant> treeMap;
    private Map<Integer, String> ids;

    public MiniYelp() {
        // initialize your data structure here.
        ids = new HashMap<>();
        treeMap = new TreeMap<>();
    }

    // @param name a string
    // @param location a Location
    // @return an integer, restaurant's id
    public int addRestaurant(String name, Location location) {
        // Write your code here
        Restaurant restaurant = Restaurant.create(name, location);
        String hash = GeoHash.encode(location) + "." + restaurant.id;
        ids.put(restaurant.id, hash);
        treeMap.put(hash, restaurant);
        return restaurant.id;
    }

    // @param restaurant_id an integer
    public void removeRestaurant(int restaurant_id) {
        // Write your code here
        if (ids.containsKey(restaurant_id)) {
            String hash = ids.get(restaurant_id);
            ids.remove(restaurant_id);
            if (treeMap.containsKey(hash))
                treeMap.remove(hash);
        }
    }

    // @param location a Location
    // @param k an integer, distance smaller than k miles
    // @return a list of restaurant's name and sort by
    // distance from near to far.
    public List<String> neighbors(Location location, double k) {
        // Write your code here
        int len = get_len(k);
        String hash = GeoHash.encode(location);
        hash = hash.substring(0, len);
        List<Node> res = new ArrayList<>();
        for (Map.Entry<String, Restaurant> entry : treeMap.subMap(hash, true, hash + "{", true).entrySet()) {
            String key = entry.getKey();
            Restaurant val = entry.getValue();
            double dis = Helper.get_distance(location, val.location);
            if (dis <= k)
                res.add(new Node(dis, val));
        }
        Collections.sort(res, (a, b) -> a.distance < b.distance ? -1 : a.distance > b.distance ? 1 : 0);
        List<String> ans = new ArrayList<>();
        int n = res.size();
        for (int i = 0; i < n; i++)
            ans.add(res.get(i).restaurant.name);
        return ans;
    }

    private int get_len(double k) {
        double[] ERROR = {2500, 630, 78, 20, 2.4, 0.61, 0.076, 0.01911, 0.00478, 0.0005971, 0.0001492, 0.0000186};
        for (int i = 0; i < 12; i++) {
            if (k > ERROR[i]) {
                return i;
            }
        }
        return 12;
    }
}
