public class CatchRain {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(catchRain(height));
    }

    private static int max(int[] arr){
        int res=arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i] > res){
                res = arr[i];
            }
        }
        return res;
    }

    public static int catchRain(int[] height){
        int res = 0;
        int tmp = 0;
        int maxheight = max(height);

        for(int i=1; i<=maxheight;i++){
            boolean start = false;

            for(int j = 0; j<height.length;j++){
                if(start && height[j] < 1){
                    tmp++;
                }else{
                    res += tmp;
                    tmp = 0;
                    start = true;
                }

            }
        }
        return res;
    }
}
