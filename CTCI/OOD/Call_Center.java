public Enum Rank{
    Respondent (2), Manager (1), Director (0);
    private int rank;
    public Rank(int r){
        this.rank = r;
    }
    public int getRank(){
        return rank;
    }
}

public abstract class Employee{

    private Call currentCall = null;
    protected Rank rank;

    public Employee(CallHandler handler){}
    public void receiveCall(Call call){}
    public void callCompleted(){}
    public void escalateAndReassign(){}
    public boolean assignNewCall(){}
    public boolean isFree(){return currentCall == null;}
    public int getRank(){return rank.getRank();}
}

public class Director extends Employee{
    public Director(){rank = Rank.Director}
}

public class Manager extends Employee{
    public Manager(){rank = Rank.Manager;}
}

public class Respondent extends Employee{
    public Respondent(){rank = Rank.Respondent;}
}

public class Call{
    private Rank rank;
    private Caller caller;
    private Employee handler;

    public Call(Caller caller){
        this.caller = caller;
        this.rank = Rank.Respondent;
    }

    public void setHandler(Employee e){this.handler = e;}
    public void reply(String text){}
    public int getRank(){return rank.getRank();}
    public void setRank(Rank r){this.rank = r;}
    public void incrementRank(){}
    public void disconnect(){}
}

public class CallHandler{

    private final int LEVEL = 3;
    private final int NUM_RESPONDENTS = 8;
    private final int NUM_MANAGER = 4;
    private final int NUM_DIRECTOR = 2;

    List<List<Employee>> employeeLevels;
    List<List<Call>> callQueues;

    public CallHandler(){}

    public Employee getHandlerForCall(){}
    public void dispatchCall(Caller caller){
        Call call = new Call(caller);
        dispatchCall(call);
    }

    public void dispatchCall(Call call){
        Employee emp = getHandlerForCall(call);
        if(emp != null){
            call.setHandler(emp);
            emp.receiveCall(call);
        }
        else{
            call.reply("Please wait for free employee to reply");
            callQueues.get(call.getRank()).add(call);
        }
    }
    public boolean assignCall(Employee emp){}
}