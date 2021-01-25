
/**
 * Write a description of class Map here.
 *
 * Modified and extended by Galimir Bozmarov, Max Roe and Edrick Yapi
 * @version 2020.01.25
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
        home = new Room("currently in your Home. If you go north you can go outside", 
        Items.AXE);
        outside = new Room("outside, east of you is the park.\n West of you is the University.\n North of you is McDonalds.\n South to go back to home", Items.NONE);
        park = new Room("now in the park. You see no other direction, but to go back.\n West to go back to outside", Items.NONE);
        university = new Room("now at the University. You see no other direction, but to go back.\n East to go back to outside", Items.BACKPACK);
        mcdonalds = new Room("now at McDonalds. East of you is the pub.\n South to go back to outside", Items.BURGER);
        pub = new Room("now at the pub. South of you is Tesco.\n West to go back to McDonalds", Items.DRINK);
        tesco = new Room("now at Tesco. South of you is an Abandoned House.\n North to go back to pub", Items.DRINK);
        abandoned_house = new Room("now at the Abandoned House. West of you is a Petrol Station.\n North to go back to Tesco", Items.TORCH);
        petrol_station = new Room("now at the Petrol Station. North of you is the Barbers.\n East to go back to Abandoned House", Items.NONE);
        barbers = new Room("now at the Barbers. North of you is the Cinema.\n South to go back to Petrol Station", Items.NONE);
        cinema = new Room("now at the Cinema. North of you is the Office.\n South to go back to barbers", Items.TORCH);
        office = new Room("now at the Office. West of you is the Train Station.\n South to go back to cinema",Items.BANDAGES);
        train_station = new Room("now at the Train Station. South of you is the Police Station.\n East to go back to office", Items.NONE);
        police_station = new Room("now at Police Station. East of you is a Car Park.\n North to go back to Train Station", Items.GUN);
        car_park = new Room("now at the Car Park. East of you are the woods.\n West to go back to Police Station", Items.NONE);
        woods = new Room("reached the final destination, now you can escape the city that was overtaken by the zombies.\n Type 'quit' to end game! ", Items.NONE);
        
        // initialise room exits
        home.setExit("north", outside);
        outside.setExit("south", home);
        outside.setExit("east", park);
        outside.setExit("west", university);
        outside.setExit("north", mcdonalds);
        park.setExit("west", outside);
        university.setExit("east", outside);
        mcdonalds.setExit("south", outside);
        mcdonalds.setExit("east", pub);
        pub.setExit("west", mcdonalds);
        pub.setExit("south", tesco);
        tesco.setExit("north", pub);
        tesco.setExit("south", abandoned_house);
        abandoned_house.setExit("north", tesco);
        abandoned_house.setExit("west", petrol_station);
        petrol_station.setExit("east", abandoned_house);
        petrol_station.setExit("north", barbers);
        barbers.setExit("south", petrol_station);
        barbers.setExit("north", cinema);
        cinema.setExit("south", barbers);
        cinema.setExit("north", office);
        office.setExit("south", cinema);
        office.setExit("west", train_station);
        train_station.setExit("east", office);
        train_station.setExit("south", police_station);
        police_station.setExit("north", train_station);
        police_station.setExit("east", car_park);
        car_park.setExit("west", police_station);
        car_park.setExit("east", woods);
        
        
        startRoom = home;  // start game outside
    }
    
    public Room getStartRoom()
    {
        return startRoom;
    }
}
