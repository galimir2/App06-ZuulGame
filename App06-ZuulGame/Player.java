import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    //Attributes
    private String name;
    private int score;
    private int maximumhealth;
    
    private ArrayList <Items> itemList;
    
    public Player(String name)
    {
        score = 0;
        maximumhealth = 100;
        itemList = new ArrayList<>();
        
    }
    
    public boolean hasItem(Items targetItem)
    {
        for(Items item : itemList)
        {
            if (item == targetItem)
                return true;
        }
        return false;
    }
    
    public void pickupItem(Items item)
    {
        itemList.add(item);
        if (item == Items.AXE)
        {
            score = score + 5;
        }
        if (item == Items.DRINK)
        {
            score = score + 5;
        }
        if (item == Items.BANDAGES)
        {
            score = score + 5;
        }
        if (item == Items.BURGER)
        {
            score = score + 5;
        }
        if (item == Items.GUN)
        {
            score = score + 5;
        }
        if (item == Items.BACKPACK)
        {
            score = score + 5;
        }
        if (item == Items.TORCH)
        {
            score = score + 5;
        }
    }
    
    public void increaseScore(int amount)
    {
        this.score = score + amount;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void setMaxiumHealth(int maximumhealth)
    {
        this.maximumhealth = maximumhealth;
    }
    
    public int getMaximumHealth()
    {
        return maximumhealth;
    }
    
    public void printStats()
    {
        System.out.println("Your Statistics. ");
        System.out.println("Score =  " + score);
        System.out.println("Health = " + maximumhealth);
    }
}
