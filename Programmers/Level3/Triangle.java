import java.util.*;

class Triangle {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        for(int i=1; i<n; i++) {
            triangle[i][0] += triangle[i-1][0];
            for(int j=1; j<i; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
            triangle[i][i] += triangle[i-1][i-1];
        }
        
        int[] result = triangle[n-1];
        Arrays.sort(result);
        return result[n-1];
    }
}
