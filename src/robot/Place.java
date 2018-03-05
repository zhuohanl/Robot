/*
 * This is class for PLACE
 */
package robot;

/**
 *
 * @author selinali
 */
public class Place {

    //fields
    public int x;
    public int y;
    public String face;

    //constructor
    public Place() {

    }

    public Place(int x, int y, String face) {
        this.x = x;
        this.y = y;
        this.face = face;
    }

    //getter and setter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getFace() {
        return face;
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

    @Override
    public String toString() {
//        return "Place{" + "x=" + x + ", y=" + y + ", face=" + face.toUpperCase() + '}';
        return x + "," + y + "," + face.toUpperCase();
    }

    public void report() {
        System.out.println("Output: " + this);
    }

    public void move() {

        int increment = 1;
        int min = 0;
        int max = 5;

        if (this.face.toLowerCase().equals("north")) {
            int newY = this.y + increment;
            if (newY >= min && newY <= max) {
                this.setY(newY);
            } else {
                this.reportFall();
            }
        } else if (this.face.toLowerCase().equals("south")) {
            int newY = this.y - increment;
            if (newY >= min && newY <= max) {
                this.setY(newY);
            } else {
                this.reportFall();
            }
        } else if (this.face.toLowerCase().equals("west")) {
            int newX = this.x - increment;
            if (newX >= min && newX <= max) {
                this.setX(newX);
            } else {
                this.reportFall();
            }
        } else if (this.face.toLowerCase().equals("east")) {
            int newX = this.x + increment;
            if (newX >= min && newX <= max) {
                this.setX(newX);
            } else {
                this.reportFall();
            }

        }

    }

    public void toLeft() {

        if (this.face.toLowerCase().equals("north")) {
            this.setFace("west");
        } else if (this.face.toLowerCase().equals("west")) {
            this.setFace("south");
        } else if (this.face.toLowerCase().equals("south")) {
            this.setFace("east");
        } else if (this.face.toLowerCase().equals("east")) {
            this.setFace("north");
        }

    }

    public void toRight() {

        if (this.face.toLowerCase().equals("north")) {
            this.setFace("east");
        } else if (this.face.toLowerCase().equals("east")) {
            this.setFace("south");
        } else if (this.face.toLowerCase().equals("south")) {
            this.setFace("west");
        } else if (this.face.toLowerCase().equals("west")) {
            this.setFace("north");
        }

    }

    public void reportFall() {

        System.out.println("Action prevented as the robot will fall out of the table");

    }

}
