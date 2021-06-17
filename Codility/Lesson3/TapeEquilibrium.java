class TapeEquilibrium {
    public int solution(int[] A) {
        int sumN = 0;
        for(int i=0; i<A.length; i++) {
            sumN += A[i];
        }

        int sumP = 0;
        int min = Integer.MAX_VALUE;
        for(int i=1; i<A.length; i++) {
            sumN -= A[i-1];
            sumP += A[i-1];
            int diff = Math.abs(sumN-sumP);
            if(min > diff) {
                min = diff;
            }
        }
        return min;
    }
}
