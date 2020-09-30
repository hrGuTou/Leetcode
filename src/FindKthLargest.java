import java.util.Arrays;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {4,3,2,1};
        findKthLargest(nums, 2);
    }

    static void findKthLargest(int[] nums, int k){
        int n = nums.length;
        quicksort(nums, 0, n-1);
        System.out.println(Arrays.toString(nums));



        //return nums[n-k];

    }

    static void quicksort(int[] nums, int start, int end){
        if(start<end){
            int index = partition(nums, start, end);
            quicksort(nums, start, index-1);
            quicksort(nums, index+1, end);
        }
    }

    static int partition(int[]nums, int start, int end){
        System.out.println("===");
        int pivot = Math.max(nums[0],nums[1]);
       int left = start;
       int right = end;

       while(left<right){
           //find the right num that's smaller than  the pivot
           while(nums[right]>=pivot && left < right){
               right--;
           }

           //find the left num that's bigger than the pivot
           while(nums[left]<=pivot && left < right){
               left++;
           }



           swap(nums, left, right);

       }
        //swap pivot with last left
       swap(nums, start, left);

       return left;
    }

     static void swap(int[]n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}
