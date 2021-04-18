import java.util.*;

class Prime {
    Set<Integer> set = new HashSet<>();
    String nums;
    
    public int solution(String numbers) {
        nums = numbers;
        
        for(int i=1; i<=nums.length(); i++) {
            boolean[] visited = new boolean[nums.length()];
            permutation(i, "", visited);
        }
        
        return set.size();
    }
    
    public void permutation(int r, String str, boolean[] visited) {
        if(r == 0) {
            if(isPrime(Integer.parseInt(str))) {
                set.add(Integer.parseInt(str));
            }
            return;
        }
        
        for(int i=0; i<nums.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(r-1, str+nums.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i<=(int)Math.sqrt(n); i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
