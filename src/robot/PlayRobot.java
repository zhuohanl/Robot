/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.util.Scanner;

/**
 *
 * @author selinali
 */
public class PlayRobot {
    
    public Place place = null;
    
    public void play(Scanner in){
        
        System.out.println("Please enter your commands below: (put EXIT if you want to exit)\n");

        //continuous input and output
        while (true) {

            // instantiate ReadCommand class
            ReadCommand rc = new ReadCommand();

            try {
                
                //obtain validated command
                Command command = rc.validateCommand(rc.obtainCommand(in));

                //process command
                
                // if user input "exit", exit the programme
                if (command.getName().equals("exit")){
                    
                    System.out.println("Are you sure to exit? Y/N");
                    
                    String confirm = in.nextLine();
                    
                    if (confirm.toLowerCase().equals("y")){
                        break;
                    } else if(confirm.toLowerCase().equals("n")){
                        continue;
                    } else {
                        System.out.println("Your input cannot be recognized. Please put EXIT if you want to exit");
                    }
                        
                    //if user input "PLACE" command
                } else if (command.getName().equals("place")) {

                    place = new Place(command.getX(), command.getY(), command.getFace());

                    //for those non-PLACE command, if user has no input, or if input invalid, report error message
                } else if (place == null) {

                    System.out.println("No valid place detected. Please input at least one place: \n");

                    //for those non-PLACE command, if input valid, process
                } else {

                    if (command.getName().equals("move")) {
                        place.move();
                    } else if (command.getName().equals("left")) {
                        place.toLeft();
                    } else if (command.getName().equals("right")) {
                        place.toRight();
                    } else if (command.getName().equals("report")) {
                        place.report();
                    }
                }
                
                System.out.println();

            } catch (Exception e) {
                
            }

        }
    }
    
}
