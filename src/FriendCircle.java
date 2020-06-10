import java.util.Arrays;

public class FriendCircle {
    //private static int count;
    private static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {
        int[][] case1 = {{1,1,0},
                        {1,1,0},
                        {0,0,1}};

        int[][] case2 = {{1,1,0},
                        {1,1,1},
                        {0,1,1}};

        int[][] case3 = {{1,0,0},
                {0,1,0},
                {0,0,1}};

        int[][] case4 = {{1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}};

        System.out.println(findCircleNum(case2));
    }

    static int findCircleNum(int[][] M){
        int count = 0;
        int[] visited = new int[M.length];
        for(int i=0;i<M.length;i++){
            if(visited[i] != 1){
                dfs(M, visited,i);
                count++;
            }
        }
        return count;
    }

    static void dfs(int[][]M, int[] visited, int person){
        for(int friend=0; friend<M[person].length; friend++){
            if(M[person][friend] == 1 && visited[friend]!=1) {
                visited[friend] = 1;
                dfs(M, visited, friend);
            }
        }



    }

}
