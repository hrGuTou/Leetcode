import java.util.Arrays;

public class mystery{

    public static void main(String []args){
        int[] nums = {1,2,3,4,5,6,7};
        helper(nums, 7, -123);
        System.out.println(Arrays.toString(nums));
    }

    public static void helper(int[] nums, int n, int p){
        int l=1; int r=n;
        while(l<r){
            while(l<r && nums[l-1]<p){
                l++;
            }
            while(l<r && nums[r-1]>=p){
                r--;
            }

            if(l<r){
                swap(nums, l, r);
            }
        }
    }

    public static void swap(int[] nums, int l, int r){
        int tmp = nums[l-1];
        nums[l-1]=nums[r-1];
        nums[r-1] = tmp;
    }
}