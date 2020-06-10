import java.util.*;


public class byteDance {

    public static void changeData(StringBuffer strBuf) {
        StringBuffer sb2 = new StringBuffer("Hi，I am ");
        strBuf = sb2;
        sb2.append("World!");
        System.out.println(strBuf);
    }

    public static String mulString(String num1, String num2){
        int len1 = num1.length();
        int len2 = num2.length();

        int[] res = new int[len1+len2];
        Arrays.fill(res, 0);

        for(int i=len1-1; i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int tmp=(num1.charAt(i)-'0')* (num2.charAt(j)-'0');
                int tens = i+j;//十位
                int ones=i+j+1;//个位
                int sum = tmp + res[ones];
                res[ones] = sum % 10;
                res[tens] += (int)sum/10;
            }
        }

        int i = 0;
        for(;i<res.length && res[i]==0;i++);

        res= Arrays.copyOfRange(res,i,res.length);
        return Arrays.toString(res);

    }

    public static String reverseWords(String s){
        if(s.equals("")) return "";
        s = s.trim().replaceAll("\\s+"," ");
        int len = s.length()-1;
        int start, end = len+1;
        String res = "";

        while(len>=0){

            if(s.charAt(len) == ' '){
                start = len+1;

                while(start != end){
                    res += s.charAt(start);
                    start++;
                }

                res+=' ';

                end = len;
            }

            len--;

        }

        start =0;
        while(start!=end){
            res+=s.charAt(start);
            start++;
        }

        return res;

    }

    public static void main(String []args) {
        String str="the   sky";
        str = str.trim().replaceAll("\\s+"," ");
        System.out.println(reverseWords(str));
    }
}
