import java.util.*;

class Triangle {
    public int solution(int[] A) {
        Arrays.sort(A);

        for(int i=0; i<A.length-2; i++) {
            if(A[i]+(long)A[i+1] > A[i+2]) {    // long: 숫자 범위 overflow 발생 방지
                return 1;
            }
        }
        return 0;
    }
}
