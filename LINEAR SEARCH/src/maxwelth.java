public class maxwelth {

        public int maximumWealth(int[][] accounts) {
            int ans = Integer.MIN_VALUE;

            for( int [] row : accounts){
                int sum = 0;
                for ( int anInt : row){
                    sum +=anInt;
                }
                if ( sum > ans){
                    ans = sum;
                }

            }
            return ans;
        }
    }

