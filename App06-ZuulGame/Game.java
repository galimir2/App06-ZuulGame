 /**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Your name
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        createCommands();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room home, outside, park, university, mcdonalds, pub, tesco, abandoned_house, 
        petrol_station, barbers,cinema, office, train_station, police_station, 
        car_park,woods;
      
        // create the rooms
        home = new Room("You are currently in your home. If you go north you can go outside", 
        Items.AXE);
        outside = new Room("You are outside, east of you is the park.", 
        Items.NONE);
        park = new Room("You are now in the park. West of you is the University.", 
        Items.NONE);
        university = new Room("You are now at the University. West of you is McDonalds", 
        Items.BACKPACK);
        mcdonalds = new Room("You are now at McDonalds. East of you is the pub.", 
        Items.BURGER);
        pub = new Room("You are now at the pub. South of you is Tesco.", 
        Items.DRINK);
        tesco = new Room("You are now at Tesco. South of you is an Abandoned House.", 
        Items.DRINK);
        abandoned_house = new Room("You are now at the Abandoned House. South of you is a Petrol Station.", 
        Items.TORCH);
        petrol_station = new Room("You are now at the Petrol Station. North of you is the Barbers.", 
        Items.NONE);
        barbers = new Room("You are now at the Barbers. North of you is the Cinema.", 
        Items.NONE);
        cinema = new Room("You are now at the Cinema. North of you is the Office.", 
        Items.TORCH);
        office = new Room("You are now at the Office. West of you is the Train Station.", 
        Items.BANDAGES);
        train_station = new Room("You are now at the Train Station. South of you is the Police Station.", 
        Items.NONE);
        police_station = new Room("You are now at Police Station. East of you is a Car Park.", 
        Items.GUN);
        car_park = new Room("You are now at the Car Park. East of you are the woods.", 
        Items.NONE);
        woods = new Room("You have reached the final destination, now you can escape the city that was overtaken by the zombies.", 
        Items.NONE);
        
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
        
        
        currentRoom = home;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }
    
    /**
     * Create the game commands
     */
    private void createCommands()
    {    
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
