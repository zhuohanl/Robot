/*
 * This is the main class.
 */
package robot;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author selinali
 */
public class Robot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NullPointerException, Exception {

        // initiate scanner
        Scanner in = new Scanner(System.in);

        // play the robot
        PlayRobot pr = new PlayRobot();
        pr.play(in);

        // goodbye message
        System.out.println("\nThank you for playing the robot! Bye!");

        // close scanner
        in.close();

    }

}
