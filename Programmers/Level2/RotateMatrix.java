class RotateMatrix {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows+1][columns+1];
        int num = 1;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                matrix[i][j] = num++;
            }
        }
        
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int r1 = queries[i][0], c1 = queries[i][1];
            int r2 = queries[i][2], c2 = queries[i][3];
            
            int curr = matrix[r1][c1];
            int next = 0;
            int min = num;
            
            for(int j=c1; j<c2; j++) {  // right
                min = Math.min(min, curr);
                next = matrix[r1][j+1];
                matrix[r1][j+1] = curr;
                curr = next;
            }
            for(int j=r1; j<r2; j++) {  // down
                min = Math.min(min, curr);
                next = matrix[j+1][c2];
                matrix[j+1][c2] = curr;
                curr = next;
            }
            for(int j=c2; j>c1; j--) {  // left
                min = Math.min(min, curr);
                next = matrix[r2][j-1];
                matrix[r2][j-1] = curr;
                curr = next;
            }
            for(int j=r2; j>r1; j--) {  // up
                min = Math.min(min, curr);
                next = matrix[j-1][c1];
                matrix[j-1][c1] = curr;
                curr = next;
            }
            answer[i] = min;
        }
        return answer;
    }
}

/*
class RotateMatrix2 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows+1][columns+1];
        int num = 1;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                matrix[i][j] = num++;
            }
        }
        
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int r1 = queries[i][0], c1 = queries[i][1];
            int r2 = queries[i][2], c2 = queries[i][3];
            
            int tmp = matrix[r1][c1];
            int min = num;
            
            for(int j=r1; j<r2; j++) {  // up
                min = Math.min(min, matrix[j][c1]);
                matrix[j][c1] = matrix[j+1][c1];
            }
            for(int j=c1; j<c2; j++) {  // left
                min = Math.min(min, matrix[r2][j]);
                matrix[r2][j] = matrix[r2][j+1];
            }
            for(int j=r2; j>r1; j--) {  // down
                min = Math.min(min, matrix[j][c2]);
                matrix[j][c2] = matrix[j-1][c2];
            }
            for(int j=c2; j>c1; j--) {  // right
                min = Math.min(min, matrix[r1][j]);
                matrix[r1][j] = matrix[r1][j-1];
            }
            matrix[r1][c1+1] = tmp;
            answer[i] = min;
        }
        return answer;
    }
}
*/
