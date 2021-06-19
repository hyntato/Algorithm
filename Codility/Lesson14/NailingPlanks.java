import java.util.*;

class NailingPlanks {
    private int M;
    private int N;
    private int[][] nails;
    private int maxIdx;

    public int solution(int[] A, int[] B, int[] C) {
        M = C.length;
        N = A.length;
        nails = new int[M][2];
        maxIdx = 0;

        for(int i=0; i<M; i++) {
            nails[i][0] = C[i];
            nails[i][1] = i;
        }
        Arrays.sort(nails, (o1, o2) -> o1[0]-o2[0]);

        for(int i=0; i<N; i++) {
            int minIdx = binarySearch(A[i], B[i]);
            
            if(minIdx == -1) {
                return -1;
            }
            else if(minIdx > maxIdx) {
                maxIdx = minIdx;
            }
        }
        return maxIdx+1;
    }

    public int binarySearch(int start, int end) {
        int min = 0;
        int max = M-1;
        int nailsIdx = -1;
        int minIdx = M-1;

        while(min <= max) {
            int mid = (min+max)/2;
            int[] nail = nails[mid];
            
            if(nail[0] < start) {
                min = mid+1;
            }
            else if(nail[0] > end) {
                max = mid-1;
            }
            else {
                max = mid-1;
                nailsIdx = mid;
            }
        }
        
        if(nailsIdx == -1) {
            return -1;
        }

        for(int i=nailsIdx; i<M; i++) {
            int[] nail = nails[i];
            if(nail[0] > end) {
                break;
            }
            if(nail[1] < minIdx) {
                minIdx = nail[1];
            }
            if(minIdx <= maxIdx) {
                break;
            }
        }
        return minIdx;
    }
}
