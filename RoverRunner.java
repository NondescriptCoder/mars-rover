
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
        Rover r2 = new Rover("Spirit", 0, 0, 2);
        Rover r3 = new Rover();
        
        System.out.println(r3);
        r3.setName("Sojourner");
        System.out.println(r3);
        
     
        r2.move(3); 
        System.out.println(r2);
        r2.rotate(1);
        r2.move(2);
        System.out.println(r2);
        
        r1.move(100);
        
        

}
}
