public class Workingout {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};

        System.out.println(solve(matrix));
    }

    public static int solve(int[][] mat){
        int[][] dp1 = new int[mat.length+1][mat[0].length+1];
        int[][] dp2 = new int[mat.length+1][mat[0].length+1];
        int[][] dp3 = new int[mat.length+1][mat[0].length+1];
        int[][] dp4 = new int[mat.length+1][mat[0].length+1];

        for(int i=1; i<dp1.length; i++){
            for(int j=1; j<dp1[0].length; j++){
                dp1[i][j] = Math.max(dp1[i-1][j], dp1[i][j-1]) + mat[i-1][j-1];
            }
        }


    }
}
