public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(findLengthOfLCIS(nums));
    }

    static int findLengthOfLCIS(int[] nums){
        int res = 1;
        int n = nums.length;
        int current = 1;

        for(int i=1; i<n; i++){
            if(nums[i-1]<nums[i]){
                current++;
                res = Math.max(res, current);
            }else{
                current = 1;
            }
        }
        return res;

    }
}
