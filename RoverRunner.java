
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
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover("Spirit", 0, 0, 1);
        Rover r3 = new Rover();
        
        System.out.println(r3);
        r3.setName("name");
        System.out.println(r3);
        
        int count = 0;
        while (count<5)
        {
        r2.move();
        System.out.println(r2);
        count++;
        }
        r2.rotateRight();
        count = 0;
        while (count<2)
        {
        r2.move();
        System.out.println(r2);
        count++;
        }
        
        r1.setName("Sojourner");
         System.out.println(r1);
        r1.move();
         System.out.println(r1);
        r1.rotateLeft();
        System.out.println(r1);
        r1.move();
        System.out.println(r1);
        r1.takePic();
        System.out.println(r1);
        
        r1.destroy(r2);
        r2.move();
        System.out.println(r2);
       
}
}
