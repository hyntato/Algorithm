class PassingCars {
    public int solution(int[] A) {
        int count = 0;
        int zero = 0;

        for(int i=0; i<A.length; i++) {
            if(A[i] == 0) {
                zero++;
            } else {
                count += zero;
            }
            if(count > 1000000000) return -1;
        }
        return count;
    }
}
