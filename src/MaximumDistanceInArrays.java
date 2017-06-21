//Do again
/**
 * Created by jniu on 6/20/17.
 */
public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.isEmpty()) return 0;
        List<Integer> arr1 = arrays.get(0), arr2 = arrays.get(1);
        int[] distBounds = calDist(0, arr1.get(0), arr1.get(arr1.size()-1), arr2.get(0), arr2.get(arr2.size()-1));

        for(int i = 2; i<arrays.size();i++){
            List<Integer> cur = arrays.get(i);
            distBounds = calDist(distBounds[0], distBounds[1], distBounds[2], cur.get(0), cur.get(cur.size()-1));
        }
        return distBounds[0];
    }

    private int[] calDist(int dist, int min1, int max1, int min2, int max2){
        int d1 = max1 - min2, d2 = max2 - min1;
        int left = Math.min(min1, min2);
        int right = Math.max(max1, max2);
        if (d1 > dist && d1 >= d2){
            return new int[]{d1, left, right};
        }
        if (d2 > dist && d2 >= d1){
            return new int[]{d2, left, right};
        }
        return new int[]{dist, left, right};
    }
}

//better solution:
private class MaximumDistanceInArrays2 {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> a1 = arrays.get(0);
        int maxDist = 0, minVal = a1.get(0), maxVal = a1.get(a1.size()-1);
        for (int i = 1; i<arrays.size(); i++){
            List<Integer> cur = arrays.get(i);
            int cMin = cur.get(0), cMax = cur.get(cur.size()-1);
            maxDist = Math.max(maxDist, Math.max(maxVal - cMin, cMax-minVal));
            maxVal = Math.max(maxVal, cMax);
            minVal = Math.min(minVal, cMin);
        }
        return maxDist;
    }
}