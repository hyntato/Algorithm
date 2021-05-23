import java.util.*;

class MaxExpression {
    private String ep;
    private long max = 0;
    
    public long solution(String expression) {
        ep = expression;
        
        List<String> list = new ArrayList<String>();
        if(expression.contains("+")) list.add("+");
        if(expression.contains("-")) list.add("-");
        if(expression.contains("*")) list.add("*");
        
        boolean[] visited = new boolean[list.size()];
        permutation(list, visited, list.size(), "");
        
        return max;
    }
    
    public void permutation(List<String> list, boolean[] visited, int r, String priority) {
        if(r == 0) {
            long cal = calculate(priority);
            max = Math.max(max, Math.abs(cal));
            return;
        }
        
        for(int i=0; i<list.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(list, visited, r-1, priority+list.get(i));
                visited[i] = false;
            }
        }
    }
    
    public long calculate(String priority) {
        List<Long> numList = new ArrayList<Long>();
        String[] nums = ep.replaceAll("[-+*]", " ").split(" ");
        for(String num: nums) {
            numList.add(Long.parseLong(num));
        }
        
        List<String> opList = new ArrayList<String>();
        String[] ops = ep.replaceAll("[0-9]", "").split("");
        for(String op: ops) {
            opList.add(op);
        }
        
        for(String p: priority.split("")) {
            while(opList.indexOf(p) != -1) {
                int idx = opList.indexOf(p);
                long result = 0;

                if(p.equals("+")) {
                    result = numList.get(idx) + numList.get(idx+1);
                } else if(p.equals("-")) {
                    result = numList.get(idx) - numList.get(idx+1);
                } else {
                    result = numList.get(idx) * numList.get(idx+1);
                }
                
                numList.remove(idx+1);
                numList.remove(idx);
                numList.add(idx, result);
                opList.remove(idx);
            }
        }
        return numList.get(0);
    }
}
