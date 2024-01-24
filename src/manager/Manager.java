/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import display.Display;
import entity.Fruit;
import entity.Order;
import getData.GetData;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Dat
 */
public class Manager {

    Display display = new Display();
    GetData getData = new GetData();

    public void createFruit(ArrayList<Fruit> listFruit) {
        //loop util user want exit
        while (true) {
            int id;
            String name;
            double price;
            int quantity;
            String origin;
            //loop util id is correct
            while (true) {
                id = getData.getInteger("Enter fruit ID: ", 0, Integer.MAX_VALUE);
                //check duplicate id
                if (checkDuplicateID(id, listFruit)) {
                    System.out.println("This ID is exist, enter again!!");
                } else {
                    break;
                }
            }

            name = getData.getString("Enter fruit name: ");
            price = getData.getDouble("Enter price: ");
            quantity = getData.getInteger("Enter quantity: ", 0, Integer.MAX_VALUE);
            origin = getData.getString("Enter origin: ");
            Fruit newFruit = new Fruit(id, name, price, quantity, origin);
            listFruit.add(newFruit);
            String continueAdd = getData.getYesNo("Do you want to continue (Y/N)?");
            //check cotinue add or not
            if (!continueAdd.equalsIgnoreCase("Y")) {
                break;
            }
        }
        display.displayList(listFruit);
    }

    boolean checkDuplicateID(int inputID, ArrayList<Fruit> listFruit) {
        //access all element in list
        for (Fruit fruit : listFruit) {
            //check id of fruit in list with input id
            if (fruit.getFruitID() == inputID) {
                return true;
            }
        }
        return false;
    }

    public void viewOrder(Hashtable<String, ArrayList<Order>> listOrder) {
        //check list order is empty or not
        if (listOrder.isEmpty()) {
            System.out.println("Don't have any order in list!!!");
        } else {
            //access all element in list
            for (String name : listOrder.keySet()) {
                ArrayList<Order> listOrderByName = listOrder.get(name);
                display.displayListOrder(listOrderByName);
            }
        }
    }

    public void shoping(ArrayList<Fruit> listFruit, Hashtable<String, ArrayList<Order>> listOrder) {
        //check list fruit is empty or not
        if (listFruit.isEmpty()) {
            System.out.println("Don't have any fruit in shop!!!");
        } else {
            ArrayList<Fruit> fruitBought = new ArrayList<>();
            //loop util user submit order
            while (true) {
                Fruit fruitChoise = getFruit(listFruit);
                System.out.println("You selected: " + fruitChoise.getFruitName());
                int quantity = getData.getQuatity("Please input quantity: ", 0, fruitChoise.getQuantity());
                //set quantity in shop after sell
                fruitChoise.setQuantity(fruitChoise.getQuantity() - quantity);
                //check fruit is empty or not, if empty delete 
                if (fruitChoise.getQuantity() == 0) {
                    listFruit.remove(fruitChoise);
                }
                //check frui exist in listOrder and plush quantity
                if (getFruitExistInListBought(fruitChoise, fruitBought) != null) {
                    Fruit fruitExistInListBought = getFruitExistInListBought(fruitChoise, fruitBought);
                    fruitExistInListBought.setQuantity(fruitExistInListBought.getQuantity() + quantity);
                } else {
                    Fruit fruitOder = new Fruit(fruitChoise.getFruitID(), fruitChoise.getFruitName(),
                            fruitChoise.getPrice(), quantity, fruitChoise.getOrigin());
                    fruitBought.add(fruitOder);
                }
                String continueBuy = getData.getYesNo("Do you want to order now (Y/N)?");
                if (continueBuy.equalsIgnoreCase("Y")) {
                    break;
                }
                //check list fruit is empty or not
                if (listFruit.isEmpty()) {
                    System.out.println("Don't have fruit in shop!!");
                    break;
                }
            }
            display.displayList(fruitBought);
            String nameOfCus = getData.getString("Input your name: ");
            Order newOrder = new Order(nameOfCus, fruitBought);
            //check key name is exist or not
            if (listOrder.containsKey(nameOfCus)) {
                ArrayList<Order> listOrderNow = listOrder.get(nameOfCus);
                listOrderNow.add(newOrder);
            } else {
                ArrayList<Order> newListOrder = new ArrayList<>();
                newListOrder.add(newOrder);
                listOrder.put(nameOfCus, newListOrder);
            }
            System.out.println("Add order successfuly!");
        }
    }

    private Fruit getFruit(ArrayList<Fruit> listFruit) {
        Fruit fruitResult = null;
        int count = 1;
        System.out.format("| ++ %-4s ++ | ++ %-10s ++ | ++ %-6s ++ | ++ %-6s ++"
                + "\n", "Item", "Fruit Name", "Origin", "Price");
        //display menu 
        for (Fruit fruit : listFruit) {
            System.out.println(String.format("     %-10s   %-10s         %-8s       %-8s    ", count,
                    fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice() + "$"));
            count++;
        }
        int choice = getData.getInteger("Select an item: ", 1, listFruit.size());
        fruitResult = listFruit.get(choice - 1);
        return fruitResult;
    }

    private Fruit getFruitExistInListBought(Fruit fruitChoise, ArrayList<Fruit> fruitBought) {
        //access all fruit in list bought
        for (Fruit fruit : fruitBought) {
            //check same id with fruitChoise
            if (fruitChoise.getFruitID() == fruit.getFruitID()) {
                return fruit;
            }
        }
        return null;
    }

}
