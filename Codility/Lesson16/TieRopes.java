class TieRopes {
    public int solution(int K, int[] A) {
        int sum = 0;
        int count = 0;

        for(int i=0; i<A.length; i++) {
            sum += A[i];
            if(sum >= K) {
                sum = 0;
                count++;
            }
        }
        return count;
    }
}
