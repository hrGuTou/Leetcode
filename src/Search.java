









public class Search {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(search(nums, 3));
    }

    static int search(int[] nums, int target){
        //find the smallest elem
        int low = 0;
        int high = nums.length-1;

        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        //low = the smallest

        int rotation = low;
        low = 0;
        int n=nums.length;
        high = n-1;

        while(low<high){
            int mid = (low+high)/2;
            int realmid = (mid+rotation)%n;

            if(nums[realmid] == target) return realmid;
            else if(nums[realmid]<target) low = mid+1;
            else{high = mid;}

        }
        return -1;
    }
}
