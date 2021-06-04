import java.util.*;

class BannedUser {
    private Set<Set<String>> allSet = new HashSet<>();
    private String[] user_id;
    private String[] banned_id;
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        permutation(user_id.length, banned_id.length, new LinkedHashSet<String>());
        
        return allSet.size();
    }
    
    public void permutation(int n, int r, Set<String> set) {
        if(r == 0) {
            if(isBannedId(set)) {
                allSet.add(new LinkedHashSet<>(set));
            }
            return;
        }
        for(int i=0; i<n; i++) {
            if(!set.contains(user_id[i])) {
                set.add(user_id[i]);
                permutation(n, r-1, set);
                set.remove(user_id[i]);
             }
        }
    }
    
    public boolean isBannedId(Set<String> set) {
        int idx = 0;
        for(String s1: set) {
            String s2 = banned_id[idx++];
            if(s1.length() == s2.length()) {
                for(int i=0; i<s1.length(); i++) {
                    if(s2.charAt(i) != '*' && s2.charAt(i) != s1.charAt(i)) {
                        return false;
                    }
                }
            }
            else return false;
        }
        return true;
    }
}
