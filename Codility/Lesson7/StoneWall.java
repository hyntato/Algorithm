import java.util.*;

class StoneWall {
    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for(int h: H) {
            while(true) {
                if(stack.isEmpty() || stack.peek() < h) {
                    stack.push(h);
                    break;
                }
                if(stack.peek() == h) {
                    break;
                }
                if(stack.peek() > h) {
                    stack.pop();
                    count++;
                }
            } 
        }

        return count+stack.size();
    }
}
