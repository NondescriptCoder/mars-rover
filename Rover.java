
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
    private int numPics = 0;
    private int roverDamage;
    private int energy;

    // constructor(s)
    // THIS MEANS THAT IT ACCESSES UNIVERSAL RATHER THAN LOCAL
    public Rover()
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.roverDamage = 0;
        this.energy = 100;

    }

    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.roverDamage = 0;
        this.energy = 100;
    }

    public Rover(String name, int x, int y, int dir)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.roverDamage = 0;
        this.energy = 100;
    }

    public void  setName(String name)
    {
        this.name = name;
    }

    // methods - stuff the Rover can do
    
    private void error()
    {
      System.out.println("UNABLE TO MOVE, CHECK BATTERY LEVEL AND SIGNS OF DAMAGE");
    }
        
    public void move(int distance)
    {
        if (roverDamage < 100 && energy > 0)
        {
                if (dir == 0)
                {
                    y += distance;
                }
                if (dir == 1)
                {
                    y += distance;
                    x += distance;
                }
                if (dir == 2)
                {
                    x += distance;
                }
                if (dir == 3)
                {
                    y -= distance;
                    x += distance;
                }
                if (dir == 4)
                {
                    y -= distance;
                }
                if (dir == 5)
                {
                    y -= distance;
                    x -= distance;
                }
                if (dir == 6)
                {
                    x -= distance;
                }
                if (dir == 7)
                {
                    y += distance;
                    x -= distance;
                }
            System.out.println(name + " moved in direction " + dir);
            energy -= distance;
          
        }
        else
        {
            error();
        }
    }
    
    public void move() 
    {
      move(1);
    }
    
    public void rotate (int distance)
    {
        if(roverDamage < 100 && energy > 0)
        {
            if (distance < 0)
            {
                rotateLeft(distance*-1);
            }
            else
            {
                rotateRight(distance);
            } 
            energy -= Math.abs(distance);
        }
        else
        {
           error(); 
        }
    }
    
    public void rotateLeft(int distance) 
    {
            distance = distance%8;
            distance = (8-distance);
            dir += distance;      
            System.out.println(name + " turned to the left");   
    }

    public void rotateRight(int distance)
    {
            dir += distance;
            dir = dir%8;
            System.out.println(name + " turned to the right");    
    }

        private String getDirectionName(int dir)
    {
            String direction;
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
            return direction;
    }
    
    public void takePic()
    {
        if (roverDamage < 100 && energy > 0)
        {
            numPics ++;
            System.out.println("Picture taken at [" + x + ", " + y + "] to the " + getDirectionName(dir) + " by " + name);
            energy --;
        }
        else
        {
            error();
        }    
    }

    public void damage(Rover other)
    {
        if (roverDamage < 100 && energy > 0 && other.roverDamage < 100)
        {
            System.out.println(this.name + " damaged " + other.name);
            int damageTaken = (int)(100.0/(1.0+(Math.sqrt(Math.pow((this.x-other.x),2))+(Math.pow((this.y-other.y),2)))));
            other.roverDamage = other.roverDamage + damageTaken;
        }
        else if (roverDamage < 100 && energy > 0)
        {
            System.out.println("To attempt to damage that which is already broken is a foolish and fruitless endeavor,\n and you should be ashamed for attempting to pursue it");
        }
        else
        {
            error();
        }
    }

    public String toString() 
    {
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + " picturesTaken=" +numPics+ " Health= " +(100-roverDamage)+ "% Energy= " +energy+ "% ]\n";
    }
}
