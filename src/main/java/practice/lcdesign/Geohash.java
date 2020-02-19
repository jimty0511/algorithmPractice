package practice.lcdesign;

// 529. Geohash
// Chapter 5
public class Geohash {
    /*
     * @param latitude: one of a location coordinate pair
     * @param longitude: one of a location coordinate pair
     * @param precision: an integer between 1 to 12
     * @return: a base32 string
     */
    public String encode(double latitude, double longitude, int precision) {
        // write your code here
        String base32 = "0123456789bcdefghjkmnpqrstuvwxyz";
        String latBin = getBin(latitude, -90, 90);
        String lngBin = getBin(longitude, -180, 180);
        StringBuilder sb = new StringBuilder();
        StringBuilder hash = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            sb.append(lngBin.charAt(i));
            sb.append(latBin.charAt(i));
        }
        for (int i = 0; i < 60; i += 5) {
            int idx = b2i(sb.substring(i, i + 5));
            hash.append(base32.charAt(idx));
        }
        return hash.substring(0, precision);
    }

    private int b2i(String bin) {
        return Integer.parseInt(bin, 2);
    }

    private String getBin(double value, double left, double right) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            double mid = (left + right) / 2.0;
            if (value > mid) {
                left = mid;
                sb.append(1);
            } else {
                right = mid;
                sb.append(0);
            }
        }
        return sb.toString();
    }
}
