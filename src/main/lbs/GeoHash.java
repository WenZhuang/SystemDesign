package main.lbs;

/**
 * @author wenzhuang
 * @date 2020/1/26 10:31 PM
 */

public class GeoHash {

    private final static String BASE32 = "0123456789bcdefghjkmnpqrstuvwxyz";

    private final static double MIN_LAT = -90;

    private final static double MAX_LAT = 90;

    private final static double MIN_LNG = -180;

    private final static double MAX_LNG = 180;
    /*
     * @param latitude: one of a location coordinate pair
     * @param longitude: one of a location coordinate pair
     * @param precision: an integer between 1 to 12
     * @return: a base32 string
     */
    public String encode(double latitude, double longitude, int precision) {
        // write your code here
        long binCode = 0;
        double minLat = MIN_LAT, maxLat = MAX_LAT, minLng = MIN_LNG, maxLng = MAX_LNG;
        for (int i = 0; i < precision * 5; i++){
            if ((i & 1) == 0) {
                double midLng = (maxLng + minLng) / 2;
                if (longitude > midLng){
                    binCode = ((binCode << 1) | 1);
                    minLng = midLng;
                } else {
                    binCode = (binCode << 1);
                    maxLng = midLng;
                }
            } else {
                double midLat = (maxLat + minLat) / 2;
                if (latitude > midLat){
                    binCode = ((binCode << 1) | 1);
                    minLat = midLat;
                } else {
                    binCode = (binCode << 1);
                    maxLat = midLat;
                }
            }
        }
        String hashCode = "";
        for (int i = 0; i < precision; i++){
            int code = (int)((binCode >> ((precision - i - 1) * 5)) & 31);
            hashCode += BASE32.charAt(code);
        }
        return hashCode;
    }

    /*
     * @param geohash: geohash a base32 string
     * @return: latitude and longitude a location coordinate pair
     */
    public double[] decode(String geohash) {
        // write your code here
        long binCode = 0;
        for (int i = 0; i < geohash.length(); i++){
            int index = BASE32.indexOf(geohash.charAt(i));
            binCode = (binCode << 5) + index;
        }
        double minLat = MIN_LAT, maxLat = MAX_LAT, minLng = MIN_LNG, maxLng = MAX_LNG;
        for (int k = 0; k < 5 * geohash.length(); k++){
            long b = binCode >> (5 * geohash.length() - k - 1);
            if ((k & 1) == 1){
                if ((b & 1) == 1){
                    minLat = (maxLat + minLat) / 2;
                } else {
                    maxLat = (maxLat + minLat) / 2;
                }
            } else {
                if ((b & 1) == 1){
                    minLng = (maxLng + minLng) / 2;
                } else {
                    maxLng = (maxLng + minLng) / 2;
                }
            }
        }
        return new double[]{(minLat + maxLat) / 2, (minLng + maxLng) / 2};
    }
}