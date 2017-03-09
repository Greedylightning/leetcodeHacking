public Enum GameState{
    WON, LOST, PLAYING;
}

public class Cell{

    private int row;
    private int column;
    private int value;
    private boolean isBoom;
    private boolean isExposed;
    private boolean isGussed;

    public Cell(int r, int c){
        row = r;
        column = c;
    }

    public int getValue(){return value;}
    public boolean flip(){
        isExposed = true;
        return !isBoom;
    }

    public boolean toggleGuess(){
        if(!isExposed) isGussed = !isGussed;
        return isGussed;
    }
}

public class Board{

    private int rows;
    private int columns;
    private Cell[][] cells;
    private Cell[] booms;
    private int nBooms = 0;
    private int cellUnexposed;

    public Board(int r, int c, int b){}
    private void initializeBoard(){}
    private boolean flipCell(Cell cell){}
    private void expandBlank(){}
    public int getNumRemaining(){return cellUnexposed;}
}

public class UserPlay{
    private int row;
    private int column;
    private boolean isGuess;
}

pulic class UserResult{
    boolean succeed;
}

public class Game{

    private int row;
    private int column;
    private Board board;
    private int numbooms;
    private GameState state;

    public Game(int r, int c, int b){}
    public boolean initialze(){}
    public boolean playGame(){}
}