public class solution(){

    public boolean isPalindrome(String x){
        int[] table = getTable(x);
        return check(table);
    }

    public boolean check(int[] table){
        boolean flag = false;
        for(int i = 0; i < table.length; i++){
            if(flag) return false;
            if(table[i] % 2 != 0) flag = true;
        }
        return true;
    }

    public int[] getTable(String x){
        int[] table = new int['z'-'a'+1];
        for(char c : x.toCharArray()){
            int index = getCharNumber(c);
            if(index != -1){
                table[index]++;
            }
            return table;
        }
    }

    public int getCharNumber(Char x){
        int low = Character.getNumericValue('a');
        int high = Character.getNumericValue('z');
        if(x >= low && x <= high) return Character.getNumericValue(x);
        return -1;
    }
}