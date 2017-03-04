public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        while(num != 1){
            if(num % 4 != 0) return false;
            num = num / 4;
        }
        return true;
}

public boolean isPowerOfFour(int num) {
     if(num <= 0) return false;
     int mask = num - 1;
     if(num & mask != 0) return false;
     return true; 
            
}