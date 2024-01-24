/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import entity.Fruit;
import entity.Order;
import java.util.ArrayList;

/**
 *
 * @author Dat
 */
public class Display {

    public void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM\n"
                + "1. Create Fruit\n"
                + "2. View orders\n"
                + "3. Shopping (for buyer)\n"
                + "4. Exit");
    }

    public void displayList(ArrayList<Fruit> listFruit) {
        System.out.format("%-5s|%-10s|%-6s|%-7s|%-5s\n", "ID", "Name", "Price",
                "Quatity", "Origin");
        //access all element in list
        for (Fruit fruit : listFruit) {
            System.out.println(fruit.toString());
        }
    }

    public void displayOneOrder(Order order) {
        ArrayList<Fruit> listOfItemBought = order.getListOfItemBought();
        int total = 0;
        int count = 1;
        System.out.printf("%-15s|%-15s|%-15s|%-15s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fruit : listOfItemBought) {
            System.out.printf("%-15s %-15d %-1s           %-1s           \n",count + fruit.getFruitName(),
                    fruit.getQuantity(), fruit.getPrice()+"$",
                    fruit.getPrice()*fruit.getQuantity()+"$");
            total += fruit.getPrice()*fruit.getQuantity();
            count++;
        }
        System.out.println("Total: " + total+"$");
    }
    
        public void displayListOrder(ArrayList<Order> listOrder) {
        for (Order order : listOrder) {
            System.out.println("Customer: " + order.getCustomerName());
            displayOneOrder(order);
        }
    }
}
