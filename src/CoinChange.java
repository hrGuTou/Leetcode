import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CoinChange {

    public static int change(int[] coinsValues, int chargeMoney) {
        int coinsKinds = coinsValues.length;
        int[][] chargeOptimalSolution = new int[coinsKinds + 1][chargeMoney + 1];

        //当找零金额为 0 时，不需要找零，最少找零硬币数量为 0
        for (int i = 0; i <= coinsKinds; i++)
            chargeOptimalSolution[i][0] = 0;

        //System.out.println(Arrays.deepToString(chargeOptimalSolution));

        //当找零金额不为 0 时，找零硬币种类不可为 0
        for (int i = 0; i <= chargeMoney; i++)
            chargeOptimalSolution[0][i] = Integer.MAX_VALUE;

        System.out.println(Arrays.deepToString(chargeOptimalSolution));


        //money 找零金额; coinKind 硬币种类，用来表示第几种硬币
        for (int money = 1; money <= chargeMoney; money++) {
            for (int coinKind = 1; coinKind <= coinsKinds; coinKind++) {

                //找零金额小于当前硬币面值
                if (money < coinsValues[coinKind - 1]) {
                    chargeOptimalSolution[coinKind][money] = chargeOptimalSolution[coinKind - 1][money];
                    continue;
                }

                //不使用第 i(coinkind) 种硬币找零时需要的最小硬币数-- 递推 --
                //使用第 i(coinkind) 种硬币时所需的最小硬币数-- 递推 --
                int numberByCoinKind = chargeOptimalSolution[coinKind - 1][money];
                int numberNotByCoinKind = chargeOptimalSolution[coinKind][money - coinsValues[coinKind - 1]] + 1;

                //逻辑判断硬币数目选其中较小的
                chargeOptimalSolution[coinKind][money] =
                        Math.min(numberByCoinKind, numberNotByCoinKind);
            }
        }

        return chargeOptimalSolution[coinsKinds][chargeMoney];
    }

    public static void main(String []args){
        int[] coins = {1,5,6,8};
        System.out.print(change(coins,11));
    }
}
