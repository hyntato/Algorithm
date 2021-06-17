class MinAvgTwoSlice {
    public int solution(int[] A) {
        double min = (A[0]+A[1])/(double)2;
        int idx = 0;

        for (int i=2; i<A.length; i++) {
            double avg = (A[i-1]+A[i])/(double)2;
            if (min > avg) {
                min = avg;
                idx = i-1;
            }
            avg = (A[i-2]+A[i-1]+A[i])/(double)3;
            if (min > avg) {
                min = avg;
                idx = i-2;
            }
        }
        return idx;
    }
}
