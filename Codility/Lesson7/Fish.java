import java.util.*;

class Fish {
    public int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int upCnt = 0;

        for(int i=0; i<A.length; i++) {
            if(B[i] == 1) {
                stack.push(A[i]);
            } else {
                if(stack.isEmpty()) {
                    upCnt++;
                } else {
                    while(!stack.isEmpty() && stack.peek() < A[i]) {
                        stack.pop();
                    }
                    if(stack.isEmpty()) upCnt++;
                }
            }
        }
        return stack.size()+upCnt;
    }
}
