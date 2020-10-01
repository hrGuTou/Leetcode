import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CoinChange {

    public static int change(int[] coinsValues, int chargeMoney) {
        int[] dp = new int[chargeMoney+1];
        Arrays.fill(dp, chargeMoney+1);

        dp[0] = 0;

        for(int i=0; i<dp.length; i++){
            for(int coin: coinsValues){
                if(i-coin<0) continue;
                dp[i] = Math.min(1+dp[i-coin],dp[i]);
            }
        }

        if(dp[chargeMoney]==chargeMoney+1) return -1;
        return dp[chargeMoney];
    }

    public static void main(String []args){
        int[] coins = {1,5,6,8};
        System.out.print(change(coins,11));
    }
}
