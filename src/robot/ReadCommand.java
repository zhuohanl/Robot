/*
 * This class is used to:
 * 1) read user standard input line by line, 
 * 2) validate user input; and
 * 3) return a Command object for each line read. 
 */
package robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author selinali
 */
public class ReadCommand {

    //obtain input
    public String obtainCommand(Scanner in) throws Exception {

        String commandString = null;

        try {
            // read the line
            // trim() to remove whitespace in front and at end
            commandString = in.nextLine().trim().toLowerCase();

        } catch (Exception e) {
            System.out.print("Error: " + e);
        }

        return commandString;
    }

    //validate input
    public Command validateCommand(String commandString) throws InputMismatchException, NullPointerException {

        Command validatedCommand = null;
        String[] actionStrings = {"move", "left", "right", "report", "exit"};
        String[] faceStrings = {"north", "south", "west", "east"};

        try {

            String[] splitted = commandString.split(",|\\s+");

            // remove whitespace in the middle
            ArrayList<String> originalCommand = new ArrayList<String>();
            for (String s : splitted) {
                if (s != null && !s.isEmpty()) {
                    originalCommand.add(s);
                }
            }

            // Control on no input
            if (originalCommand.isEmpty()) {

                throw new NullPointerException("No valid input detected. Please input your commands: \n");

               //validate one-word command 
            } else if (originalCommand.size() == 1) {

                if (Arrays.asList(actionStrings).contains(originalCommand.get(0))) {
                    validatedCommand = new Command(originalCommand.get(0));

                } else {
                    throw new InputMismatchException("Your input command is not valid.\n");
                }

                //validate "PLACE"
            } else if (originalCommand.size() == 4) {

                String firstS = originalCommand.get(0);
                String secondS = originalCommand.get(1);
                String thirdS = originalCommand.get(2);
                String forthS = originalCommand.get(3);

                if (firstS.equals("place")
                        && isValidDigit(secondS)
                        && isValidDigit(thirdS)
                        && Arrays.asList(faceStrings).contains(forthS)) {

                    validatedCommand = new Command(firstS, Integer.parseInt(secondS), Integer.parseInt(thirdS), forthS);

                } else {
                    throw new InputMismatchException("Your input command is not valid.\n");
                }

            } else {
                throw new InputMismatchException("Your input command is not valid.\n");
            }
            
            
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return validatedCommand;
    }

    // check X and Y digit for PLACE
    public boolean isValidDigit(String s) {

        return s.matches("\\d") && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 5;

    }

}
