public class Solution{

    public String getStringCompression(String x){
        StringBuilder y = new StringBuilder();
        for(int i = 0; i < x.length(); i=i+count){
            char temp = x.charAt(i);
            int count = 1;
            for(int j = i + 1; j < x.length(); j++){
                if(x.charAt(j) != temp){
                    y.append(temp+count);
                    break;
                }
                count++;
            }
            if(i == x.length() - 1) y.append(temp+count);
        }
        if(y.length() >= x.length()) return x;
        else return y.toString();
    }
}