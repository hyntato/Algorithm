import java.util.*;

class NumberOfDiscIntersections {
    public int solution(int[] A) {
        long[] left = new long[A.length];
        long[] right = new long[A.length];

        for(int i=0; i<A.length; i++) {
            left[i] = i-(long)A[i];
            right[i] = i+(long)A[i];
        }

        Arrays.sort(left);
        Arrays.sort(right);

        int answer = 0;
        int j=0;

        for(int i=0; i<A.length; i++) {
            while(j<A.length && right[i] >= left[j]) {
                j++;
            }
            answer += j-i-1;

            if(answer > 10000000) return -1;
        }
        
        return answer;
    }
}
