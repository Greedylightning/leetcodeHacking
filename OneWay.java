public class solution{

    public boolean OneWay(String x,String y){
        if(Math.abs(x.length()-y.length()) > 1) return false;
        String s1 = x.length() > y.length() ? y : x;
        String s2 = x.length() > y.length() ? x : y;

        int index1 = 0;
        int index2 = 0;

        boolean flag = false;
        while(index1 < s1.length() && index2 < s2.length()){
            if(s1.charAt(index1) != s2.charAt(index2)){
                if(flag) return false;
                flag = true;
                if(s1.length() == s2.length()) index1++;
            }
            else index1++;
            index2++;
        }
        return true;
    }
}