package test.lbs;

import main.lbs.GeoHash;

/**
 * @author wenzhuang
 * @date 2020/1/26 10:44 PM
 */
public class GeoHashTest {

    public static void main(String[] args){
        GeoHash geoHash = new GeoHash();
        double[] res = geoHash.decode("dqc5prgxzb");
        System.out.println(res[0] + " " + res[1]);
    }
}
