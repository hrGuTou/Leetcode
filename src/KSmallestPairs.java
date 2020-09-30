import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs {

    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        //System.out.println(kSmallestPairs(nums1,nums2,3));
        System.out.println(getLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4));
    }

    public static ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>( (i1,i2) -> i2.compareTo(i1) );

        for (int i = 0; i < length; i++) {
            if(maxHeap.size()!=k){
                maxHeap.offer(input[i]);
            }else if(maxHeap.peek()>input[i]){
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }

        while (!maxHeap.isEmpty()) {
            Integer i = maxHeap.poll();
            System.out.println(i);
        }

        return result;
    }

}
