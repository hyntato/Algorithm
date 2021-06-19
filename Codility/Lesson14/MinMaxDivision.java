class MinMaxDivision {
    public int solution(int K, int M, int[] A) {
        int max = 0;
        int min = 0;
        for(int n: A) {
            max += n;
        }
        while(min <= max) {
            int mid = (min+max)/2;
            if(isPossible(mid, K, M, A)) {
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return min;
    }

    public boolean isPossible(int largeSum, int K, int M, int[] A) {
        int sum = 0;
        int count = 1;

        for(int i=0; i<A.length; i++) {
            if(A[i] > largeSum) {
                return false;
            }
            if(sum+A[i] <= largeSum) {
                sum += A[i];
            } else {
                sum = A[i];
                count++;
            }
        }
      
        if(count > K) {
            return false;
        } else {
            return true;
        }
    }
}
