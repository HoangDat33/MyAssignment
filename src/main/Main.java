/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import getData.GetData;
import display.Display;
import entity.Fruit;
import entity.Order;
import manager.Manager;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Dat
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Display display = new Display();
        GetData getData = new GetData();
        Manager manager = new Manager();
        ArrayList<Fruit> listFruit = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> listOrder = new Hashtable<>();
        //loop util user enter exit
        while (true) {
            //Step 1: Display menu
            display.displayMenu();
            //Step 2: Ask user select an option
            int option = getData.getUserChoise("(Please choose 1 to create product, 2 to "
                    + "view order, 3 for shopping, 4 to Exit program):", 1, 4);
            //Step 3: Do option selected by user
            switch (option) {
                // Option 1: Create fruit
                case 1:
                    manager.createFruit(listFruit);
                    break;
                //Option 2: View orders
                case 2:
                    manager.viewOrder(listOrder);
                    break;
                //Option 3: Shopping   
                case 3:
                    manager.shoping(listFruit, listOrder);
                    break;
                //Option 4: Exit
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

}
