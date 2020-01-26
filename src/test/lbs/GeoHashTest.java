package test.lbs;

import main.lbs.GeoHash;

/**
 * @author wenzhuang
 * @date 2020/1/26 10:44 PM
 */
public class GeoHashTest {

    public static void main(String[] args){
        GeoHash geoHash = new GeoHash();
        String code = geoHash.encode(0.00, 90.00, 12);
        System.out.println(code);
    }
}
