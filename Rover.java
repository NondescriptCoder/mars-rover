
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
    
    /**
     * Constructs a rover given no parameters
     */
    public Rover()
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.roverDamage = 0;
        this.energy = 100;

    }
    
    /**
     * Constructs a rover given only the name
     * 
     * @param name The name assigned to the rover
     */
    public Rover(String name)
    {
        this.name = name;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
        this.roverDamage = 0;
        this.energy = 100;
    }

    /**
     * Constructs a rover given its name, position, and direction
     * 
     * @param name The name assigned to the rover
     * @param x The x-coordinate of the rover (east-west; east is positive)
     * @param y The y-coordinate of the rover (north-south; north is positive)
     * @param dir The direction the rover is facing, a number from 0-7, counted clockwise with North as 0
     */
    public Rover(String name, int x, int y, int dir)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.roverDamage = 0;
        this.energy = 100;
    }
    
    /**
     * Changes the name of a rover
     * 
     * @param name The name you want the rover to have
     */
    public void  setName(String name)
    {
        this.name = name;
    }

    // methods - stuff the Rover can do
    
    /**
     * Prints an error message if the rover is unable to act
     */
    private void error()
    {
      if(roverDamage < 100)
      {
         System.out.println("INSUFFICIENT BATTERY");
      }
      else
      {
         System.out.println("q yu64 e5d7trf89y0hunmj-kjho88tr7f568fgtvr76fR*TIFCRt689"); 
      }
    }
    
    /**
     * Causes the rover to move in a straight line in the direction it is facing for a set distance
     * 
     * @param distance How far you would like the rover to move
     */
    public void move(int distance)
    {
        if (roverDamage < 100 && energy > distance)
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
            System.out.println(name + " moved " +distance+ " units to the " + getDirectionName(dir));
            energy -= distance;
          
        }
        else
        {
            error();
        }
    }
    
    /**
     * When no parameters are entered for move, the rover will move 1 unit forward
     */
    public void move() 
    {
      move(1);
    }
    
    /**
     * Rotates the rover a set distance by calling either rotateLeft() or rotateRight()
     * 
     * @param distance How far the rover will rotate clockwise (positive) or counterclockwise (negative)
     */
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
    
    /**
     * Rotates the rover a specific distance left
     * 
     * @param distance How far the rover will rotate
     */
    public void rotateLeft(int distance) 
    {
            distance = distance%8;
            distance = (8-distance);
            dir += distance;
            dir = dir%8;
            System.out.println(name + " turned to the left");   
    }

    /**
     * Rotates the rover a specific distance right
     * 
     * @param distance How far the rover will rotate
     */
    public void rotateRight(int distance)
    {
            dir += distance;
            dir = dir%8;
            System.out.println(name + " turned to the right");    
    }
    
    /**
     * Teleports the rover to a specific set of  coordinates
     * 
     * @param x The x-coordinate the rover will teleport to
     * @param y The y-coordinate the rover will teleport to
     */
    public void teleport(int x, int y)
    {
        if (roverDamage < 100 && energy > (int)(Math.sqrt(Math.pow((this.x-x), 2)+Math.pow((this.y-y),2))))
        {
           energy = energy - (int)(Math.sqrt(Math.pow((this.x-x), 2)+Math.pow((this.y-y),2)));
           this.x = x;
           this.y = y;  
           System.out.println(name + " teleported to " +x+ ", " +y+ " ");
        }
        else
        {
            error();
        } 
    }
    
    /**
     * Sets the direction the rover is facing
     * 
     * @param direction The direction the rover should face, a number from 0-7, counted clockwise with North as 0
     */
    public void setDirection(int direction)
    {
        if (direction != dir)
        {
            if(Math.abs(direction-dir)>4)
            {
                direction += 8;
            }
           rotate(direction-dir);
           energy -=  Math.abs(direction-dir);
           System.out.println(name + " turned to the " + getDirectionName(dir));
        }
    }

    /**
     * Moves the rover to a specific set of  coordinates
     * 
     * @param x The x-coordinate the rover will move to
     * @param y The y-coordinate the rover will move to
     */
    public void moveTo(int x, int y)
    {
        int lesserDifference;
        if ((Math.abs(this.x-x)) < (Math.abs(this.y-y)))
        {
           lesserDifference = Math.abs(this.x-x);
        }
        else
        {
           lesserDifference = Math.abs(this.y-y);
        }
        
        while ((this.x != x || this.y != y) && energy > 0 && roverDamage < 100)
        {
            if(this.x == x && this.y < y)
            {
                setDirection(0);
                move(y-this.y);
            }
            else if (this.x < x && this.y < y)
            {
                setDirection(1);
                move(lesserDifference);
            }
            else if (this.x < x && this.y == y)
            {
                setDirection(2);
                move(x-this.x);
            }
            else if (this.x < x && this.y > y)
            {
                setDirection(3);
                move(lesserDifference);
            }
            else if (this.x == x && this.y > y)
            {
                setDirection(4);
                move(this.y-y);
            }
            else if (this.x > x && this.y > y)
            {
                setDirection(5);
                move(lesserDifference);
            }  
            else if (this.x > x && this.y == y)
            {
                setDirection(6);
                move(this.x-x);
            }
            else if (this.x > x && this.y < y)
            {
                setDirection(7);
                move(lesserDifference);
            }
        }
    }
    
    /**
     * Gets the name of the direction the rover is facing
     * 
     * @param dir Inputs the numerical value for the rover's direction
     */
        private String getDirectionName(int dir)
    {
            String direction;
            switch(dir)
            {
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
    
    /**
     * Causes the rover to take a picture, counts the number of pictures taken, and determines where the picture is taken and to what direction
     */
    public void takePic()
    {
        if (roverDamage < 100 && energy > 0)
        {
            numPics ++;
            System.out.println("Picture taken at [" + x + ", " + y + "] to the " + getDirectionName(dir) + " by " + name);
            energy -= 2;
        }
        else
        {
            error();
        }    
    }
    
    /**
     * Charges the rover, or damages the rover in the case that the battery is overloaded
     * 
     * @param chargeLevel Determines how much the rover's energy (and/or damage) is increased
     */
    public void charge(int chargeLevel)
    {
        energy += chargeLevel;
        
        if (energy > 100)
        {
            roverDamage += (energy-100);
            System.out.println("WARNING: ROBOT OVERHEATING");
            energy = 100;
        }
        System.out.println(name+ " charged to " +energy+ "%");
        
    }
    
    /**
     * Allows rovers to attack other rovers
     * 
     * @param other Determines which rover the rover should attack
     */
    public void damage(Rover other)
    {
        if (roverDamage < 100 && energy > 0 && other.roverDamage < 100)
        {
            System.out.println(this.name + " damaged " + other.name);
            int damageTaken = (int)(100.0/(1.0+(Math.sqrt(Math.pow((this.x-other.x),2))+(Math.pow((this.y-other.y),2)))));
            other.roverDamage = other.roverDamage + damageTaken;
            energy -= 3;
        }
        else if (other.roverDamage >= 100 && energy > 0)
        {
            System.out.println("To attempt to damage that which is already broken is a foolish and fruitless endeavor,\n and you should be ashamed for attempting to pursue it");
            energy--;
        }
        else
        {
            error();
        }
    }
    
    /**
     * Prints information about the rover
     */
    public String toString() 
    {
        if (energy < 0)
        {
            energy = 0;
        }
        if(roverDamage > 100)
        {
            roverDamage = 100;
        }
        return "Rover[name=" + name + ", x=" + x + ", y=" + y + ", dir=" + dir + " picturesTaken=" +numPics+ " Health=" +(100-roverDamage)+ "% Energy=" +energy+ "% ]\n";
    }
}
