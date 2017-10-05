
/**
 * Write a description of class RoverRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoverRunner
{

    public static void main(String[] arrrggggggs)
    {
        boolean on = true;

        SimpleScanner input = new SimpleScanner();
        Rover r1 = new Rover("Bob",0,0,0);
        Rover r2 = new Rover ("Billy",1,1,1);
        Rover r3 = new Rover ("Benjamin",2,2,2);

        RoverGroup group = new RoverGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);

        while (on)
        {
            String name = input.readString();
            Rover r = group.find(name);
            if (r != null)
            {
                if (input.readString().equals("exit"))
                {
                    on = false;
                    System.out.println("Code Terminated");
                }
                if(input.readString().equals("help"))
                {
                    System.out.println("w = move forward\na = turn left\nd = turn right");
                }
                else if (input.readString().equals("w"))
                {
                    r.move();
                }
                else if (input.readString().equals("d"))
                {
                    int distance = input.readInt();
                    r.rotateRight(distance);
                }
                else if(input.readString().equals("a"))
                {
                    int distance = input.readInt();
                    r.rotateLeft(distance);
                }
                System.out.println(r1);
            }
            else
            {
              System.out.println("Rover name invalid");
            }
            }
        }
    }
