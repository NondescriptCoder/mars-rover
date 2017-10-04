
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
        SimpleScanner input = new SimpleScanner();
        Rover r1 = new Rover("Bob",0,0,0);
      if (input.readString().equals("w"))
      {
          r1.move();
      }
      System.out.println(r1);


    }
}
