
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
            System.out.print("Input Rover Name Or Non-Rover Command: ");
            String name = input.readString();
            Rover r = group.find(name);
            if (r != null)
            {
                System.out.print("What do you want the rover to do?: ");
                String  action = input.readString();

                if (action.equals("w"))
                {
                    System.out.print ("How far?");
                    int distance = input.readInt();
                    r.move(distance);
                }
                else if (action.equals("d"))
                {
                    System.out.print ("How far?");
                    int distance = input.readInt();
                    r.rotate(distance);
                }
                else if(action.equals("a"))
                {
                    System.out.print ("How far?");
                    int distance = input.readInt();
                    r.rotate(distance*-1);
                }
                else if(action.equals("t"))
                {
                    System.out.print("What x-coordinate?");
                    int x = input.readInt();
                    System.out.print("y?");
                    int y = input.readInt();
                    r.teleport(x, y);
                }
                else if(action.equals("m"))
                {
                    System.out.print("What x-coordinate?");
                    int x = input.readInt();
                    System.out.print("y?");
                    int y = input.readInt();
                    r.moveTo(x, y);
                }
                else if(action.equals("p"))
                {
                    r.takePic();
                }
                    
                System.out.println(r);
            }
            else
            {
                if (name.equals("exit"))
                {
                    on = false;
                    System.out.println("Code Terminated");
                }
                else if(name.equals("help"))
                {
                    System.out.println("Rover Commands:\nw = move forward\na = turn left\nd = turn right\nt = teleport\nm = move to\np = take picture\nNon-Rover Commands:\nexit = end the program\n");
                }                
                else
                {
                   System.out.println("Rover name invalid");
                }
            }
            }
        }
    }
