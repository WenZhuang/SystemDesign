package main.lbs;

/**
 * @author wenzhuang
 * @date 2020/2/3 11:12 PM
 */

import java.util.*;

public class MiniYelp {

    private Map<Integer, String> ids = new HashMap<>();

    private TreeMap<String, Restaurant> restaurants = new TreeMap<>();

    public MiniYelp() {
        // initialize your data structure here.
    }

    // @param name a string
    // @param location a Location
    // @return an integer, restaurant's id
    public int addRestaurant(String name, Location location) {
        // Write your code here
        Restaurant restaurant = Restaurant.create(name, location);
        String geoHash = GeoHash.encode(location) + "." + restaurant.id;
        ids.put(restaurant.id, geoHash);
        restaurants.put(geoHash, restaurant);
        return restaurant.id;
    }

    // @param restaurant_id an integer
    public void removeRestaurant(int restaurant_id) {
        // Write your code here
        if (ids.containsKey(restaurant_id)){
            String geoHash = ids.get(restaurant_id);
            ids.remove(restaurant_id);
            if (restaurants.containsKey(geoHash)){
                restaurants.remove(geoHash);
            }
        }
    }

    // @param location a Location
    // @param k an integer, distance smaller than k miles
    // @return a list of restaurant's name and sort by
    // distance from near to far.
    public List<String> neighbors(Location location, double k) {
        // Write your code here
        TreeMap<Double, List<String>> distances = new TreeMap<>();
        //使用geoHash缩小搜索范围
        int len = getLength(k);
        String geoHash = GeoHash.encode(location).substring(0, len);

        for (Map.Entry<String, Restaurant> entry : restaurants.subMap(geoHash, true, geoHash + "{", true).entrySet()){
            Restaurant restaurant = entry.getValue();
            double distance = Helper.get_distance(restaurant.location, location);
            if (distance < k){
                if (!distances.containsKey(distance)){
                    distances.put(distance, new ArrayList<>());
                }
                distances.get(distance).add(restaurant.name);
            }
        }
        List<String> neighbors = new ArrayList<>();
        for (Map.Entry<Double, List<String>> entry : distances.entrySet()){
            neighbors.addAll(entry.getValue());
        }
        return neighbors;
    }

    /**
     * 根据距离误差获取geoHash前缀长度
     * @param k
     * @return
     */
    private int getLength(double k){
        double[] ERROR = {2500, 630, 78, 20, 2.4, 0.61, 0.076, 0.01911, 0.00478, 0.0005971, 0.0001492, 0.0000186};
        for (int i = 0; i < ERROR.length; i++){
            if (k > ERROR[i]){
                return i;
            }
        }
        return 12;
    }
};

class Location {
    public double latitude, longitude;
    public static Location create(double lati, double longi) {
        // This will create a new location object
        return  new Location(lati, longi);
     }

     private Location(double lati, double longi){
        this.latitude = lati;
        this.longitude = longi;
     }
}

class Restaurant {
    private static int incr_id = 0;

    public int id;
    public String name;
    public Location location;
    public static Restaurant create(String name, Location location) {
        // This will create a new restaurant object,
        // and auto fill id
        return new Restaurant(name, location);
    }

    private Restaurant(String name, Location location){
        this.name = name;
        this.location = location;
        this.id = getId();
    }

    private int getId() {
        incr_id++;
        return incr_id;
    }
};


