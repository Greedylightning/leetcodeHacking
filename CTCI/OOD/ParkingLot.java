public Enum VehicleSize{
    Motorcycle, Compact, Large;
}

public abstract class Vehicle{

    private ArrayList<ParkingSpot> parkingSpot;
    private String licensePlate;
    private int spotNeed;
    private VehicleSize size;

    public Vehicle(){}

    public int getSpotsNeed(){return spotNeed;}
    public VehicleSize getSize(){return size;}

    public void parkInSpot(ParkingSpot s){parkingSpot.add(s);}
    public void clearspot(){}
    public abstract boolean canFitInSpot(ParkingSpot spot){}
}

public class Motorcycle extends Vehicle{
    spotNeed = 1;
    size = VehicleSize.Motorcycle;

    public boolean canFitInSpot(ParkingSpot spot){}
}

public class Car extends Vehicle{
    spotNeed = 1;
    size = VehicleSize.Compact;

    public boolean canFitInSpot(ParkingSpot spot){}
}

public class Bus extends Vehicle{
    spotNeed = 5;
    size = VehicleSize.Large;

    public boolean canFitInSpot(ParkingSpot spot){}
}

public class ParkingLot{
    private Level[] levels;
    private final int NUM_LEVEL = 3;

    public ParkingLot(){}
    public boolean parkVehicle(Vehicle v){}
}

public class Level{
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int floor, int numberSpots){}

    public int availableSpots(){return availableSpots;}
    public boolean parkVehicle(){}
    private boolean parkStartingAtSpot(int num, Vehicle v){}
    private boolean findAvailableSpot(Vehicle v){}
    public void spotFreed(){availableSpots++;}
}

public class ParkingSpot{
    private Vehicle vehicle;
    private Level level;
    private int row;
    private int spotNumber;
    private VehicleSize spotSize;

    public ParkingSpot(){}
    public boolean isAvailable(){return vehicle == null}
    public boolean canFitInSpot(){}
    public void park(Vehicle v){}
    public int getRow(){return row;}
    public int getSpotNumber(){return spotNumber;}
    public void removeVehicle(){}

}