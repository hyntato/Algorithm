class MaxNonoverlappingSegments {
    public int solution(int[] A, int[] B) {
        int count = 0;
        int end = -1;

        for(int i=0; i<A.length; i++) {
            if(A[i] > end) {
                count++;
                end = B[i];
            }
        }
        return count;
    }
}
