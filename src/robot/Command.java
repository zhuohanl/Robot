/*
 * This is CLASS for command
 */
package robot;

/**
 *
 * @author selinali
 */
public class Command {
    
    //fields
    String name;
    int x; //only applicable for "PLACE"
    int y; //only applicable for "PLACE"
    String face;
    
    //constructor

    public Command() {
        
    }

    public Command(String name) {
        this.name = name;
    }
    
    

    public Command(String name, int x, int y, String face) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.face = face;
    }
    
    //getter and setter

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getFace() {
        return face;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFace(String face) {
        this.face = face;
    }
    
    
}
