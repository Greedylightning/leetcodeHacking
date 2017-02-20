public class solution{
    
    public boolean isUnique(String x){

        for(int i = 0; i < x.length() - 1; i++){
            for(int j = i + 1; j < x.length(); j++){
                if(x.charAt(i) == x.charAt(j)) return false;
            }
        }
        return true;
    }

    public boolean isUnique(String x){
        
        int[] table = new int[256];
        for(int i = 0; i < x.length(); i++){
            table[x.charAt(i)]++;
        }
        for(int i = 0; i < table.length; i++){
            if(table[i] >1) return false;
        }
        return true;
    }

    public boolean isUnique(String x){

        if(x.length() > 128) return false;

        boolean[] table = new boolean[256];
        for(int i = 0; i < x.length(); i++){
            if(table[x.charAt(i)]) return false;
            table[x.charAt(i)] = true;
        }
        return true;
    }

    public boolean isUnique(String x){
        String y = Arrays.sort(x.toCharArray()).toString();
        for(int i = 0; i < y.length() - 1; i++){
            if(y.charAt(i) == y.charAt(i + 1)) return false;
        }
        return true;
    }

}