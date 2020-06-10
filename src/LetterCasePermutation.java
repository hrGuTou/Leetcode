import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        LCP("a1b2");
    }

    static void LCP(String s){
        List<String> answers=new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);

        helper(sb, answers, 0);

        System.out.println(answers);

    }

    static void helper(StringBuilder s, List<String>ans, int pos){
        if(pos == s.length()){ //finish
            ans.add(s.toString());
            return;
        }

        if(Character.isDigit(s.charAt(pos))){ //if digit then stop that path
            helper(s, ans, pos+1);
            return;
        }

        s.setCharAt(pos,Character.toLowerCase(s.charAt(pos)));
        helper(s,ans,pos+1);

        s.setCharAt(pos,Character.toUpperCase(s.charAt(pos)));
        helper(s,ans,pos+1);


    }
}
