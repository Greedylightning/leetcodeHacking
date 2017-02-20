public class Solution(){

    public boolean checkPermutation(String x, String y){
        
        int[] table = new int[128];
        for(int i = 0; i < x.length(); i++){
            table[x.charAt(i)]++;
        }
        for(int i = 0; i < y.length(); i++){
            table[y.charAt(i)]--;
        }
        for(int i = 0; i < table.length(); i++){
            if(table[i] != 0) return false;
        }
        return true;
    }

    public boolean checkPermutation(String x, String y){

        char[] x_sort = x.toCharArray();
        char[] y_sort = y.toCharArray();
        Arrays.sort(x_sort);
        Arrays.sort(y_sort);
        String x_x = new String(x_sort);
        String y_y = new String(y_sort);
        if(x_sort.equals(y_sort)) return true;
        return false;
    }

    public boolean checkPermutation(String x, String y){

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < x.length(); i++){
            if(map.get(x.charAt(i))) map.put(x.charAt(i), map.get(x.charAt(i)) + 1);
            map.put(x.charAt(i), 1);
        }
        for(int i = 0; i < y.length(); i++){
            if(map.get(y.charAt(i))) map.put(y.charAt(i), map.get(y.charAt(i)) - 1);
            map.put(x.charAt(i), 1);
        }
        Iterator<Character> p = map.keySet().iterator();
        while(p.hasNext()){
            int value = map.get(p.next());
            if(value != 0) return false;
            
        }
        return true;
    }

}