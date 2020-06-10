import java.util.Arrays;

public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }

    static int findKthLargest(int[] nums, int k){
        int n = nums.length;
        quicksort(nums, 0, n-1);
        System.out.println(Arrays.toString(nums));



        return nums[n-k];

    }

    static void quicksort(int[] nums, int start, int end){
        if(start<end){
            int index = partition(nums, start, end);
            quicksort(nums, start, index-1);
            quicksort(nums, index+1, end);
        }
    }

    static int partition(int[]nums, int start, int end){
       int pivot = nums[start];
       int left = start;
       int right = end;

       while(left<right){
           //find the right num that's smaller than or equal to the pivot
           while(nums[right]>=pivot && left < right){
               right--;
           }

           //find the left num that's bigger than or equal to the pivot
           while(nums[left]<=pivot && left < right){
               left++;
           }



           swap(nums, left, right);

       }
        //swap pivot with last left
       swap(nums, start, left);

       return left;
    }

     static void swap(int n[], int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
}
