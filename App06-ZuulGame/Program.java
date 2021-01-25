/**
 * Write a description of class Program here.
 *
 * Modified and extended by Galimir Bozmarov, Max Roe and Edrick Yapi
 * @version 2020.01.25
 */
public class Program
{
    private static Game game;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void run()
    {
        game = new Game();
        game.play();
    }
}
