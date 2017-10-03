
/**
 * Write a description of class RoverRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoverRunner
{
    static int x;
    public static void main(String[] arrrggggggs)
    {
        Rover r1 = new Rover("Curiosity");
        Rover r2 = new Rover("Spirit", 0, 0, 2);
        Rover r3 = new Rover();
        
        System.out.println(r3);
        r3.setName("Sojourner");
        System.out.println(r3);
        
        r2.takePic();
        System.out.println(r2);
        
        r1.move();
        System.out.println(r1);
        r1.damage(r3);
        System.out.println(r3);
        System.out.println(r1);
        r1.damage(r3);
        System.out.println(r3);
        System.out.println(r1);
        r1.damage(r3);
        System.out.println(r3);
        
        System.out.println(r1);
        
        r3.move();
        System.out.println(r3);
        
        r1.moveTo(20, -17);
        System.out.println(r1);


}
}
