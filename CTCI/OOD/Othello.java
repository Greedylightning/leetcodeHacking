public Enum Color{
    Black, White;
}

public class Game{

    private Board board;
    private Player[] players;
    private int ROWS;
    private int COLUMNS;

    public Game(int row, int column){
        this.ROWS = row;
        this.COLUMNS = column;
        board = new Board(ROWS, COLUMNS);
        players = new Players[2];
        players[0] = new Player(Color.Black);
        players[1] = new Player(Color.White);
    }

    public Board getBoard(){return board;}
    public Player[] getPlayers(){return players}
    
}

public class Board{

    private blackCount;
    private whiteCount;
    private Piece[][] pieces;

    public Board(int row, int column){
        pieces = new Piece[row][column];
        blackCount = 0;
        whiteCount = 0;
    }

    public boolean placePiece(int row, int column, Color color){}
    public boolean flipSection(int row, int column, Color color, Direction d){}
    public int getScoreFromColor(Color color){
        if(color = Color.Black) return blackCount;
        else return whiteCount;
    }

}

public class Piece{
    
    private Color color;
    private boolean free;

    public Piece(){free = true;}
    public void flipPiece(){
        if(color == Color.Black) color = Color.White;
        else color = Color.Black;
    }

    public Color getColor(){return color;}
    public boolean isFree(){return free == true;}
}

public class Player{

    private Color color;
    
    public Player(Color color){this.color = color;}
    public int getScore(){}
    public boolean playPiece(){}
    public Color getColor(){return color;}
}