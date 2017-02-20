public class solution{

    public String URLify(String x, int length){
        String y = x.trim();
        StringBuilder z = new StringBuilder();
        for(int i = 0; i < y.length(); i++){
            if(y.charAt(i) == " ") z.append("%20");
            z.append(y.charAt(i));
        }
        return z.toString();
    }
}