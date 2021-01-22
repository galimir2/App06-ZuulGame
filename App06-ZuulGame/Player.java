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
    
    private ArrayList <Items> itemList;
    private int score;
    private int maximumhealth;
    
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
    
    public void takeItem(Items item)
    {
        itemList.add(item);
        if (item == Items.AXE)
        {
            score = score + 5;
        }
        else if (item == Items.DRINK)
        {
            score = score + 5;
        }
        else if (item == Items.BANDAGES)
        {
            score = score + 5;
        }
        else if (item == Items.BURGER)
        {
            score = score + 5;
        }
        else if (item == Items.GUN)
        {
            score = score + 30;
        }
        else if (item == Items.BACKPACK)
        {
            score = score + 20;
        }
        else if (item == Items.TORCH)
        {
            score = score + 30;
        }
    }
    
    public void incScore(int amount)
    {
        this.score = score + amount;
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
