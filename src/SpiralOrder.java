import java.util.Arrays;

public class SpiralOrder {
    public static void main(String[] args) {
       int[][]matrix = {{1,2,3,4},
               {5,6,7,8},
               {9,10,11,12}};
  //          int[][] matrix = {{7},{6},{9}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }

    private static int[] spiralOrder(int[][] matrix){
        if(matrix.length == 0) return new int[0];
        int rows = matrix.length;
        int cols = matrix[0].length;
        //List<Integer> res = new ArrayList<>();
        int[] res = new int[rows*cols];
        int row = 0; int col = 0;
        int idx = 0;

        while(true){
            for(int i= col; i<cols; i++) res[idx++]=matrix[row][i]; //left to right
            if(++row>rows-1) break;
            for(int i= row; i<rows; i++) res[idx++]=matrix[i][cols-1]; //top to bottom
            if(--cols-1<col) break;
            for(int i= cols-1; i>=col; i--) res[idx++]=matrix[rows-1][i]; //right to left
            if(--rows-1<row) break;
            for(int i= rows-1; i>=row; i--) res[idx++]=matrix[i][col]; // buttom to top
            if(++col>cols-1) break;

        }
        return res;

    }
}
