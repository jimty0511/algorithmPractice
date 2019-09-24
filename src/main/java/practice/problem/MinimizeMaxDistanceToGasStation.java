package practice.problem;

// 774. Minimize Max Distance to Gas Station
public class MinimizeMaxDistanceToGasStation {
    public double minmaxGasDist(int[] stations, int K) {
        double l = 0, r = stations[stations.length - 1] - stations[0];
        while (r - l >= 1e-6) {
            double mid = l + (r - l) / 2;
            int count = 0;
            for (int i = 0; i < stations.length - 1; i++) {
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }
            if (count > K)
                l = mid;
            else
                r = mid;
        }
        return l;
    }
}
