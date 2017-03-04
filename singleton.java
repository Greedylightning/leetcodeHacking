public class Student{

    private Student(){
        ;
    }
    private static final Student s = new Student();
    public static Student getInstance(){
        return s;
    }
}

public class Student{
    
    private Student(){}
    private static final Student s = null;
    public static Student getInstance(){
        if(s == null) s = new Student();
        return s;
    }
}