import java.util.*;

public class BuildSubstring {

    static List<String> res;
    public static void main(String[] args) {
        String s = "xyz";
        buildSubString(s);
    }

    public static void buildSubString(String s){
        res = new ArrayList<>();
        backtrack(s,0);
        Collections.sort(res);
        System.out.println(res);

    }

    public static void backtrack(String s, int idx){
        if(s.length() == idx){
            return;
        }
        String tmp = "";
        for(int i= idx;i<s.length();i++){

            tmp+=s.charAt(i);
            if(res.contains(tmp)) continue;
            res.add(tmp);
            backtrack(s, idx+1);
        }
    }
}
