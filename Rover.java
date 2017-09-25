
/**
 * Write a description of class Rover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rover
{
    // fields
    private String name;
    private int x;
    private int y;
    private int dir; // 0=North, 1=East, 2=South, 3=West
    private int numPics;
    private boolean isFunctional;
    
    // constructor(s)
    // THIS MEANS THAT IT ACCESSES UNIVERSAL RATHER THAN LOCAL
      public Rover()
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.numPics = 0;
        isFunctional = true;
    }
        public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.numPics = 0;
        isFunctional = true;
    }
    public Rover(String name, int x, int y, int dir)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.dir = dir;
        isFunctional = true;
    }
    
    public void  setName(String name)
    {
        this.name = name;
    }
    
    // methods - stuff the Rover can do
    public void move()
    {
        if (isFunctional)
        {
             if (dir == 0)
                {
                  y++;
                }
             if (dir == 1)
                {
                    y++;
                    x++;
                }
             if (dir == 2)
                {
                    x++;
                }
             if (dir == 3)
                {
                    y--;
                    x++;
                }
             if (dir == 4)
                {
                    y--;
                }
             if (dir == 5)
                {
                    y--;
                    x--;
                }
             if (dir == 6)
                {
                    x--;
                }
             if (dir == 7)
                {
                    y++;
                    x--;
                }
        System.out.println(name + " moved in direction " + dir);
    }
        if (!isFunctional)
        {
         System.out.println("Do you seriously think a broken rover can still do things?!");
        }
    }
    
    public void rotateLeft() 
    {
        if (isFunctional)
        {
            dir -= 1;
            
            if (dir < 0)
            {
                dir = 7;
            }
            
            System.out.println(name + " turned to the left");   
    }
        if (!isFunctional)
        {
         System.out.println("Do you seriously think a broken rover can still do things?!");
        }    
    }
    
    public void rotateRight()
    {
        if (isFunctional)
        {
            dir += 1;
            
            if (dir == 8)
            {
                dir = 0;
            }
            
            System.out.println(name + " turned to the right");    
    }
        if (!isFunctional)
        {
         System.out.println("Do you seriously think a broken rover can still do things?!");
        }    
    }
    
    public void takePic()
    {
        if (isFunctional){
            String direction;
            numPics++;
            switch(dir){
                case 0: direction = "North";
                break;
                case 1: direction = "Northeast";
                break;
                case 2: direction = "East";
                break;
                case 3: direction = "Southeast";
                break; 
                case 4: direction = "South";
                break;
                case 5: direction = "Southwest";
                break;
                case 6: direction = "West";
                break;
                case 7: direction = "Northwest";
                break;             
                default: direction = "Up";
                break;
            }     
            System.out.println("Picture taken at [" + x + ", " + y + "] to the " + direction + " by " + name);
    }
        if (!isFunctional)
        {
         System.out.println("Do you seriously think a broken rover can still do things?!");
        }    
    }

    public void destroy(Rover other)
    {
        System.out.println(this.name + " obliterated " + other.name);
        other.isFunctional = false;
    }
    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + " picturesTaken=" +numPics+ " functional = " +isFunctional+ " ]\n";
    }
}
