public class FindNearest {
    public static void main(String[] args) {
        int[] arr = {2,5,6,7,10,11,11,12,14};
        System.out.println(findNearest(arr, 13));
    }

    static int findNearest(int[] arr, int target){
        //corner case
        if(target < arr[0]) return arr[0];
        if(target > arr[arr.length-1]) return arr[arr.length-1];

        int left = 0; int right = arr.length-1;

        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == target) return arr[mid];
            else if(arr[mid] > target){
                //go left
                if(mid>0 && target>arr[mid-1]){
                    if((arr[mid]-target) > (target - arr[mid-1])){
                        return arr[mid-1];
                    }else{
                        return arr[mid];
                    }
                }
                right = mid-1;
            }
            else{
                if(mid<arr.length-1 && target<arr[mid+1]){
                    if((target-arr[mid]) > (arr[mid+1]-target)){
                        return arr[mid+1];
                    }else{
                        return arr[mid];
                    }
                }
                left = mid+1;

            }
        }
        return -1;
    }
}
