import java.util.*;

class MaxProductOfThree {
    public int solution(int[] A) {
        int N = A.length;

        Arrays.sort(A);
        
        int max1 = A[0]*A[1]*A[N-1];
        int max2 = A[N-3]*A[N-2]*A[N-1];

        if(max1 < max2)
            return max2;
        else
            return max1;
    }
}
