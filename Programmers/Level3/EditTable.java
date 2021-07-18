import java.util.*;

class EditTable {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> rmStack = new Stack<>();
        int pointer = k;
        int max = n-1;
      
        for(int i=0; i<cmd.length; i++) {
            String[] op = cmd[i].split(" ");
            switch(op[0]) {
                case "D":
                    pointer += Integer.parseInt(op[1]);
                    break;
                case "U":
                    pointer -= Integer.parseInt(op[1]);
                    break;
                case "C":
                    rmStack.push(pointer);
                    if(pointer == max) {
                        pointer--;
                    }
                    max--;
                    break;
                case "Z":
                    int rm = rmStack.pop();
                    if(rm <= pointer) {
                        pointer++;
                    }
                    max++;
                    break;
            }
        }
          
        StringBuilder sb = new StringBuilder();;
        for(int i=0; i<=max; i++) {
            sb.append("O");
        }
        while(!rmStack.isEmpty()) {
            sb.insert((int)rmStack.pop(), 'X');
        }
        return sb.toString();
    }
}
