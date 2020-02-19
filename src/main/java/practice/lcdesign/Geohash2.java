package practice.lcdesign;

// 530. Geohash II
// Chapter 5
public class Geohash2 {
    /*
     * @param geohash: geohash a base32 string
     * @return: latitude and longitude a location coordinate pair
     */
    public double[] decode(String geohash) {
        // write your code here
        String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        int[] mask = {16, 8, 4, 2, 1};
        double[] lon = {-180, 180};
        double[] lat = {-90, 90};
        boolean isEven = true;
        for (int i = 0; i < geohash.length(); i++) {
            int val = base32.indexOf(geohash.charAt(i));
            for (int j = 0; j < 5; j++) {
                if (isEven)
                    interval(lon, val, mask[j]);
                else
                    interval(lat, val, mask[j]);
                isEven = !isEven;
            }
        }
        return new double[]{(lat[0] + lat[1]) / 2.0, (lon[0] + lon[1]) / 2.0};
    }

    private void interval(double[] interval, int val, int mask) {
        if ((val & mask) > 0)
            interval[0] = (interval[0] + interval[1]) / 2.0;
        else
            interval[1] = (interval[0] + interval[1]) / 2.0;
    }
}
