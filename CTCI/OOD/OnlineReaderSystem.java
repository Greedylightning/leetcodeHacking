public class OnlineReaderSystem{

    private Library library;
    private UserManager userManager;
    private Display display;

    private Book activeBook;
    private User activeUser;

    public OnlineReaderSystem(){
        library = new Library();
        userManager = new UserManager();
        display = new Display();
    }

    public Library getLibrary(){return library;}
    public UserManager getUserManager(){return userManager;}
    public Display display(){return display;}

    public Book getActiveBook(){return activeBook;}
    public User getActiveUser(){return activeUser;}

    public void setActiveBook(Book book){
        this.activeBook = book;
        display.displayBook(book);
    }

    public void setActiveUser(User user){
        this.activeUser = user;
        display.displayUser(user);
    }
}

public class Library{

    private Map<Integer, Book> books;

    public Library(){books = new HashMap<Integer, Book>();}

    public boolean addBook(Book book){
        if(books.containsKey(book.getID())) return false;
        books.put(book.getID(), book);
        return true;
    }

    public boolean removeBook(int id){
        if(!books.containsKey(id)) return false;
        books.remove(id);
        return true;
    }

    public boolean removeBook(Book book){
        return removeBook(book.getID());
    }

    public Book searchBook(int id){
        if(!books.containsKey(id)) return null;
        return books.get(id);
    }

    public Book searchBook(Book book){
        return searchBook(book.getID());
    }
}

public class UserManager{

    private Map<Integer, User> users;

    public UserManager(){users = new HashMap<Integer, User>();}

    public boolean addUser(User user){
        if(!user.containsKey(user.getID())) return false;
        users.add(user);
        return true;
    }

    public boolean removeUser(int id){
        if(!users.containsKey(id)) return false;
        users.remove(id);
        return true;
    }

    public boolean removeUser(User user){
        return removeUser(user.getID());
    }

    public User searchUser(int id){
        if(!users.containsKey(id)) return null;
        return users.get(id);
    }

    public User searchUser(User user){
        return searchUser(user.getID());
    }
}

public class Display{

    private Book activeBook;
    private User activeUser;
    private int pageNumber;

    public Display(){pageNumber = 0;}
    public void displayBook(Book book){activeBook = book;}
    public void displayUser(User user){activeUser = user;}

    public int forwardPage(){return ++pageNumber; refreshPage();}
    public int backwardPage(){return --pageNumber; refreshPage();}

    public void refreshPage(){}
}

public class Book{
    private final int ID;
    private String title;
    private String type;
    private String details;

    public Book(int id, String title){
        this.ID = id;
        this.title = title;
    }

    public int getID(){return ID;}
}

public class User{
    private final int ID;
    private String details;
    private boolean memberShip;

    public User(int id, String details, boolean memberShip){
        this.id = ID;
        this.details = details;
        this.memberShip = memberShip;
    }

    public int getID(){return ID;}
}

