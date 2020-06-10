import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));
    }

   static  List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> answer = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            List<Integer> tmp = new ArrayList<>();
            int left = i+1;
            int right= nums.length-1;

            while(left<right){

                int sum=nums[i]+nums[left]+nums[right];

                if(sum == 0){
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    answer.add(tmp);
                    break;
                }

                else if(sum<0){
                    left++;
                }

                else{
                    right--;
                }
            }


        }


        return answer;
   }

}
