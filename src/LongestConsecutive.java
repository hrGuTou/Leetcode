import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2,5};
        System.out.println(longestConsecutive(nums));
    }

    static int longestConsecutive(int[] nums){
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            int left, right;
            if(!map.containsKey(nums[i])){
                if(map.containsKey(nums[i]-1)){
                    left = map.get(nums[i]-1);
                }else{
                    left = 0;
                }

                if(map.containsKey(nums[i]+1)){
                    right = map.get(nums[i]+1);
                }else{
                    right = 0;
                }

                int sum = left + right +1;
                map.put(nums[i], sum);
                res = Math.max(res, sum);
                map.put(nums[i]-left, sum);
                map.put(nums[i]+right, sum);
            }


        }

        return res;
    }
}
