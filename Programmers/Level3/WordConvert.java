import java.util.*;

class WordConvert {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if(curr.word.equals(target)) {
                answer = curr.depth;
                break;
            }
            
            for(int i=0; i<words.length; i++) {
                if(!visited[i] && isConvertable(curr.word, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], curr.depth+1));
                }
            }
        }
        return answer;
    }
    
    public boolean isConvertable(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        
        int diff = 0;
        for(int i=0; i<s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return diff == 1;
    }
}

class Node {
    String word;
    int depth;
    public Node(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }
}
