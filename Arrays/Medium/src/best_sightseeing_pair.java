public class best_sightseeing_pair {
    public int maxScoreSightseeingPair(int[] values) {
        int maxleft = values[0] , max = 0;
        for (int i = 1 ; i < values.length ; i++){
            max = Math.max(max , maxleft + values[i] - i);
            maxleft = Math.max(maxleft , values[i] + i);
        }
        return max;
    }
}
