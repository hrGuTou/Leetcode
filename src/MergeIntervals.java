import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] interval0 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] interval1 = {{1,10},{2,5},{6,9}};
        int[][] interval2 = {{1,10},{2,5},{6,9},{11,12}};
        int[][] interval3 = {{1,4}, {0,2},{3,5}};
        int[][] interval4 = {{1,4},{0,4}};

        System.out.println(Arrays.deepToString(merge(interval0)));
        System.out.println(Arrays.deepToString(merge(interval1)));
        System.out.println(Arrays.deepToString(merge(interval2)));
        System.out.println(Arrays.deepToString(merge(interval3)));
        System.out.println(Arrays.deepToString(merge(interval4)));


    }

    static int[][] merge(int[][] intervals){
        int n = intervals.length;
        if(n==0) return new int[][]{};
        if(n==1) return intervals;
        List<int[]> res= new ArrayList<>();
        Arrays.sort(intervals, (i1,i2)->Integer.compare(i1[0],i2[0]));
        //System.out.println(Arrays.deepToString(intervals));

        int[] startInterval = intervals[0];

        for(int i=1;i<n;i++){
            if(startInterval[1]>=intervals[i][0]){
                startInterval[1] = Math.max(startInterval[1],intervals[i][1]);
            }else{
                res.add(startInterval);
                startInterval = intervals[i];
            }

        }

        res.add(startInterval);




        return res.toArray(new int[res.size()][]);
    }
}
