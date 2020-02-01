package main.lbs;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/2/1 9:29 PM
 */


public class MiniUber {
    Map<Integer, double[]> driverLocs = new HashMap<>();
    Map<Integer, Trip> driverTrip = new HashMap<>();

    public MiniUber() {
        // initialize your data structure here.
    }

    // @param driver_id an integer
    // @param lat, lng driver's location
    // return matched trip information if there have matched rider or null
    public Trip report(int driver_id, double lat, double lng) {
        // Write your code here
        driverLocs.put(driver_id, new double[]{lat, lng});
        return driverTrip.get(driver_id);
    }

    // @param rider_id an integer
    // @param lat, lng rider's location
    // return a trip
    public Trip request(int rider_id, double lat, double lng) {
        Trip trip = new Trip(rider_id, lat, lng);
        // Write your code here
        double min_dis = Double.MAX_VALUE;
        int driver = 0;
        for (Map.Entry<Integer, double[]> entry : driverLocs.entrySet()){
            int driver_id = entry.getKey();
            if (driverTrip.containsKey(driver_id)){
                continue;
            }
            double[] loc = entry.getValue();
            double dis = Helper.get_distance(lat, lng, loc[0], loc[1]);
            if (dis < min_dis){
                min_dis = dis;
                driver = driver_id;
            }
        }
        trip.driver_id = driver;
        driverTrip.put(driver, trip);
        return trip;
    }
}

class Trip {
    public int id; // trip's id, primary key
    public int driver_id, rider_id; // foreign key
    public double lat, lng; // pick up location
    public Trip(int rider_id, double lat, double lng) {

    };
}

class Helper {
    public static double get_distance(double lat1, double lng1, double lat2, double lng2) {
        // return distance between (lat1, lng1) and (lat2, lng2)
        return 0;
    }
};