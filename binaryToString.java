public String binaryToString(double num){
    
    StringBuilder s = new StringBuilder(".");
    while(num != 0){
        num = num * 2;
        if(num >= 1){
            s.append("1");
            num = num - 1;
        }
        else s.append("0");
        if(s.length() >= 32 && num != 0){
            System.out.println("ERROR");
            break;
        }
    }

    return s.toString();
}

public String binaryToString(double num){

    StringBuilder s = new StringBuilder("0.");
    if(num < 0 || num > 1) return "ERROR";
    double factor = 0.5;
    while(num != 0){
        if(s.length() >= 32) return "ERROR";
        if(num >= factor){
            s.append("1");
            num = num - factor;
        }
        else s.append("0");
    }
    return s.toString();
}