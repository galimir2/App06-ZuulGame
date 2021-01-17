
/**
 * Write a description of class Map here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    private Room startRoom;
    
    
    /**
     * Create all the rooms and link their exits together.
     */
    public Map()
    {
        createRooms();
    }
    
    private void createRooms()
    {
        Room home, outside, park, university, mcdonalds, pub, tesco, abandoned_house, 
        petrol_station, barbers,cinema, office, train_station, police_station, 
        car_park,woods;
      
        // create the rooms
        home = new Room("You are currently in your . If you go north you can go outside", 
        Items.AXE);
        outside = new Room("outside, east of you is the park", Items.NONE);
        park = new Room("now in the park. West of you is the University", Items.NONE);
        university = new Room("now at the University. West of you is McDonalds", Items.BACKPACK);
        mcdonalds = new Room("now at McDonalds. East of you is the pub", Items.BURGER);
        pub = new Room("now at the pub. South of you is Tesco", Items.DRINK);
        tesco = new Room("now at Tesco. South of you is an Abandoned House", Items.DRINK);
        abandoned_house = new Room("now at the Abandoned House. South of you is a Petrol Station", Items.TORCH);
        petrol_station = new Room("now at the Petrol Station. North of you is the Barbers", 
        Items.NONE);
        barbers = new Room("now at the Barbers. North of you is the Cinema", Items.NONE);
        cinema = new Room("now at the Cinema. North of you is the Office", Items.TORCH);
        office = new Room("now at the Office. West of you is the Train Station",Items.BANDAGES);
        train_station = new Room("now at the Train Station. South of you is the Police Station", Items.NONE);
        police_station = new Room("now at Police Station. East of you is a Car Park", Items.GUN);
        car_park = new Room("now at the Car Park. East of you are the woods", Items.NONE);
        woods = new Room("reached the final destination, now you can escape the city that was overtaken by the zombies", Items.NONE);
        
        // initialise room exits
        home.setExit("north", outside);
        outside.setExit("east", park);
        park.setExit("west", university);
        university.setExit("west", mcdonalds);
        mcdonalds.setExit("east", pub);
        pub.setExit("south", tesco);
        tesco.setExit("south", abandoned_house);
        abandoned_house.setExit("west", petrol_station);
        petrol_station.setExit("north", barbers);
        barbers.setExit("north", cinema);
        cinema.setExit("north", office);
        office.setExit("west", train_station);
        train_station.setExit("south", police_station);
        police_station.setExit("east", car_park);
        car_park.setExit("east", woods);
        
        
        startRoom = home;  // start game outside
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
}
