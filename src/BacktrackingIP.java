import java.util.ArrayList;
import java.util.List;

public class BacktrackingIP {
    public static void main(String[] args) {

        restoreIP("0000");

    }

    static void restoreIP(String s){
        List<String> answer = new ArrayList<>();

        helper(s,answer, 0, "", 0 );
        System.out.println(answer);
    }

    static void helper(String s, List<String> answer, int pos, String res, int section){
        //base case
        if(section == 4 && pos == s.length()){
            answer.add(res);
            return;
        }

        for(int i=1;i<4;i++){
            if(i+pos > s.length()) break;
            String tmp = s.substring(pos, pos+i);

            if(tmp.length()>1 && tmp.startsWith("0") || Integer.parseInt(tmp)>255) break;


            helper(s, answer, pos+i, section == 0? tmp: res+"."+tmp, section+1 );

        }


    }


}
