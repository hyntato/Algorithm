import java.util.*;

class MaxNumber {
    
    public String solution(int[] numbers) {
        
        String[] nums = new String[numbers.length];
        for(int i=0; i<nums.length; i++) {
            nums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return (str2+str1).compareTo(str1+str2);
            }
        });
        
        if(nums[0].equals("0"))
            return "0";
        
        String answer = "";
        for(int i=0; i<nums.length; i++) {
            answer += nums[i];
        }
        return answer;
    }
    
}
