/**
 * Write a description of class Program here.
 *
 * @author Galimir Bozmarov
 * @version (13/11/2020)
 * @modified by Galimir Bzomarov
 */
public class Program
{
    private static Game game;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main()
    {
        game = new Game();
        game.play();
    }
}
