/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getData;

import java.util.Scanner;

/**
 *
 * @author Dat
 */
public class GetData {

    public int getUserChoise(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //ask user enter until it correct
        while (true) {
            try {
                System.out.print(msg);
                String input = sc.nextLine();
                //check input is empty or not
                if (input.isEmpty()) {
                    System.out.println("Input can't be empty!!!");
                } else {
                    int number = Integer.parseInt(input);
                    //check number in range or not 
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("Please enter number from " + min + " to " + max + " !!!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter number from " + min + " to " + max + " !!!");
            }
        }
    }

    public String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        //ask user enter until it correct
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            //check empty
            if (input.isEmpty()) {
                System.out.println("Input can not be empty...");
            } else {
                return input;
            }
        }
    }

    public int getInteger(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //Requires the user to enter a number in range until it is correct
        while (true) {
            System.out.print(msg);
            try {
                String inputString = sc.nextLine();
                //Check inputString is empty or not, if empty, ask to re-enter
                if (inputString.isEmpty()) {
                    System.out.println("Input cannot be empty!!!");
                } else {
                    int number = Integer.parseInt(inputString);
                    //check posNumber in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("Please enter a number from " + min + " to " + max);
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter integer number !!");
            }
        }
    }

    public String getYesNo(String msg) {
        Scanner sc = new Scanner(System.in);
        //loop util user input corresct
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            //check input empty or not
            if (input.isEmpty()) {
                System.out.println("Input can't be empty!!!");
            }
            //check input correct or not
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                return input;
            } else {
                System.out.println("Input must be Y or N!!!");
            }
        }
    }

    public int getQuatity(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        //Requires the user to enter a number in range until it is correct
        while (true) {
            System.out.print(msg);
            try {
                String inputString = sc.nextLine();
                //Check inputString is empty or not, if empty, ask to re-enter
                if (inputString.isEmpty()) {
                    System.out.println("Input cannot be empty!!!");
                } else {
                    int number = Integer.parseInt(inputString);
                    //check posNumber in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.out.println("Shop have only " + max + " product...");
                        System.out.println("Please enter a number from " + min + " to " + max);
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter integer number !!");
            }
        }
    }

    public double getDouble(String msg) {
        Scanner scanner = new Scanner(System.in);
        //ask user enter until it correct
        while (true) {
            try {
                System.out.print(msg);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Input can not be empty...");
                } else {
                    double number = Double.parseDouble(input);
                    //check number in range
                    if (number >= 0 && number <= Double.MAX_VALUE) {
                        return number;
                    } else {
                        System.out.println("Please enter number from 0 to " + Double.MAX_VALUE + " !!!");
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter number from 0 to " + Double.MAX_VALUE + " !!!");
            }
        }
    }
}
