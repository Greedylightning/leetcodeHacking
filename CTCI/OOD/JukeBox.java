public class JukeBox{
    private CDPlayer cdPlayer;
    private User user;
    private Set<CD> cdCollection;
    private SongSelector ts;

    public JukeBox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts){}
    public Song getCurrentSong(){return ts.getCurrentSong();}
    public void setUser(User u){this.user = u;}
}

public class CDPlayer{
    private PlayList p;
    private CD cd;

    public CDPlayer(PlayList p, CD c){this.p = p; this.cd = c;}
    public CDPlayer(PlayList p){this.p = p;}
    public CDPlayer(CD c){this.c = c;}
}

public class CD{
    private String name;
    private String player;
    private String publishDate;
    private Set<Song> songCollection;
}

public class User{
    private String name;
    private long ID;
}

public class Song{
    private String ID;
    private String title;
    private double length;
}

public class PlayList{
    private Song song;
    private Queue<Song> songQueue;
    
    public PlayList(){}
    public Song getNextToPlay(){return songQueue.peek();}
    public boolean addSong(Song s){this.songQueue.add(s);}
}